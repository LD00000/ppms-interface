package com.sunway.ws.core.cxf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.sunway.ws.core.utils.StringUtils;

/**
 * 处理 org.apache.cxf.message.Message
 * 
 * @author lidong
 */
public class MessageHandler {
	private static final Logger logger = LogManager.getLogger(MessageHandler.class);
	
	/**
	 * 构造 xml 数据
	 * 
	 * @param message
	 * @return
	 */
	public String setupXml(Message message, String type) {
		// ID
		String id = (String)message.getExchange().get(LoggingMessage.ID_KEY);
        if (id == null) {
            id = LoggingMessage.nextId();
            message.getExchange().put(LoggingMessage.ID_KEY, id);
        }
        final LoggingMessage buffer = new LoggingMessage("---------------------------", id);
        
        Integer responseCode = (Integer)message.get(Message.RESPONSE_CODE);
        if (responseCode != null) {
            buffer.getResponseCode().append(responseCode);
        }
        
        // Encoding
        String encoding = (String)message.get(Message.ENCODING);
        if (encoding != null) {
            buffer.getEncoding().append(encoding);
        }          
        
        // Http-Method
        String httpMethod = (String)message.get(Message.HTTP_REQUEST_METHOD);
        if (httpMethod != null) {
            buffer.getHttpMethod().append(httpMethod);
        }
        
        // address
        String address = (String)message.get(Message.ENDPOINT_ADDRESS);
        if (address != null) {
            buffer.getAddress().append(address);
            String uri = (String)message.get(Message.REQUEST_URI);
            if (uri != null && !address.startsWith(uri)) {
                if (!address.endsWith("/") && !uri.startsWith("/")) {
                    buffer.getAddress().append("/");
                }
                buffer.getAddress().append(uri);
            }
        }
        
        // Content-Type
        String ct = (String)message.get(Message.CONTENT_TYPE);
        if (ct != null) {
            buffer.getContentType().append(ct);
        }
        
        Object headers = message.get(Message.PROTOCOL_HEADERS);
        if (headers != null) {
            buffer.getHeader().append(headers);
        }
        
        // payload
        String currentPayload = "";
        if ("out".equals(type)) {
        	currentPayload = getOutPayload(message);
        } else if ("in".equals(type)) {
        	currentPayload = getInPayload(message);
        }
        buffer.getPayload().append(currentPayload);
        
		// format
		if (StringUtils.isBlank(currentPayload)) {
			return buffer.toString();
		}
		StringWriter writer = new StringWriter();
		String formatXml = "";
		try {
			Document doc = DocumentHelper.parseText(currentPayload);
			
			OutputFormat format = new OutputFormat("    ", true);
			format.setEncoding(encoding);
			
			XMLWriter xmlwriter = new XMLWriter(writer, format);
			xmlwriter.write(doc);
			xmlwriter.flush();
			formatXml = writer.getBuffer().toString();
		} catch (Exception e) {
			throw new RuntimeException("xml format error...", e);
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
				}
		}
		
		return buffer.toString() + "\n" + formatXml;
	}
	
	@SuppressWarnings("resource")
	private String getOutPayload(Message message) {
		logger.info("handleMessage() - HTTP request/responses intercepted");
		
		String currentPayload = "";
		OutputStream outputStream = message.getContent(OutputStream.class);
		CachedOutputStream cachedOutputStream = new CachedOutputStream();
		CachedOutputStream newCachedOutputStream = new CachedOutputStream();
		
        try {
            message.setContent(OutputStream.class, cachedOutputStream);

            message.getInterceptorChain().doIntercept(message);

            cachedOutputStream.flush();
            cachedOutputStream.close();

            newCachedOutputStream = (CachedOutputStream) message.getContent(OutputStream.class);
            currentPayload = IOUtils.toString(newCachedOutputStream.getInputStream(), (String)message.get(Message.ENCODING));
            newCachedOutputStream.flush();
            newCachedOutputStream.close();

            if (currentPayload != null) {
            	logger.info("handleMessage() - HTTP request/responses Length: {}", currentPayload.length());

                InputStream replaceInputStream = IOUtils.toInputStream(currentPayload, (String)message.get(Message.ENCODING));

                IOUtils.copy(replaceInputStream, outputStream);
                replaceInputStream.close();
                
                message.setContent(OutputStream.class, outputStream);
                
                outputStream.flush();
				outputStream.close();
            }
        } catch (IOException e) {
        	logger.error("handleMessage() - Error", e);
            throw new RuntimeException(e);
        } finally {
        	try {
        		if (cachedOutputStream != null)
            		cachedOutputStream.close();
            	if (outputStream != null)
            		outputStream.close();
            	if (newCachedOutputStream != null)
            		newCachedOutputStream.close();
			} catch (IOException ioe) {
			}
        }
        
        return currentPayload;
	}
	
	private String getInPayload(Message message) {
		String currentPayload = "";
//		CachedOutputStream bos = new CachedOutputStream();
//		InputStream is = message.getContent(InputStream.class);
//		try {
//			if (is != null) {
//				InputStream bis = is instanceof DelegatingInputStream ? ((DelegatingInputStream)is).getInputStream() : is;
//				IOUtils.copy(bis, bos);
//				bos.flush();
//	            bis = new SequenceInputStream(bos.getInputStream(), bis);
//			} else {
//				
//			}
//			
//			
//            message.setContent(InputStream.class, is);
//		} catch (Exception e) {
//			throw new RuntimeException("handleMessage() - Error", e);
//		} finally {
//			try {
//				if (is != null) 
//					is.close();
//				if (bos != null)
//					bos.close();
//			} catch (Exception e2) {
//			}
//		}
		
		return currentPayload;
	}
	
}
