package org.hl7.fhir.utilities.http;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import lombok.Getter;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class HTTPResult {

  @Getter
  private final int code;
  @Getter
  private final String contentType;
  @Getter
  private final byte[] content;
  @Getter
  private final String source;
  @Getter
  private final String message;
  @Getter
  private final Iterable<HTTPHeader> headers;

  public HTTPResult(String source, int code, String message, String contentType, byte[] content) {
    this(source, code, message, contentType, content, Collections.emptyList());
  }


  public HTTPResult(String source, int code, String message, String contentType, byte[] content, Iterable<HTTPHeader> headers) {
    super();
    this.source = source;
    this.code = code;
    this.contentType = contentType;
    this.content = content;
    this.message = message;
    this.headers = headers;
  }

  public void checkThrowException() throws IOException {
    if (code >= 300) {
      if (content == null || content.length == 0) {
        HTTPResultException exception = new HTTPResultException(code, message, source, null);
        throw new IOException(exception.message, exception);
      } else {
        String filename = Utilities.path("[tmp]", "http-log", "fhir-http-"+(SimpleHTTPClient.nextCounter())+".log");
        Utilities.createDirectory(Utilities.path("[tmp]", "http-log"));
        TextFile.bytesToFile(content, filename);
        HTTPResultException exception = new HTTPResultException(code, message, source, filename);
        throw new IOException(exception.message, exception);
      }
    }      
  }

  public String getContentAsString() {
    return new String(content, StandardCharsets.UTF_8);
  }


  public String getMessagefromCode() {
    switch (getCode()) {
    case 100: return ""+getCode()+" Continue";
    case 101: return ""+getCode()+" Switching Protocols";
    case 102: return ""+getCode()+" Processing Deprecated";
    case 103: return ""+getCode()+" Early Hints";
    case 200: return ""+getCode()+" OK";
    case 201: return ""+getCode()+" Created";
    case 202: return ""+getCode()+" Accepted";
    case 203: return ""+getCode()+" Non-Authoritative Information";
    case 204: return ""+getCode()+" No Content";
    case 205: return ""+getCode()+" Reset Content";
    case 206: return ""+getCode()+" Partial Content";
    case 207: return ""+getCode()+" Multi-Status";
    case 208: return ""+getCode()+" Already Reported";
    case 226: return ""+getCode()+" IM Used";
    case 300: return ""+getCode()+" Multiple Choices";
    case 301: return ""+getCode()+" Moved Permanently";
    case 302: return ""+getCode()+" Found";
    case 303: return ""+getCode()+" See Other";
    case 304: return ""+getCode()+" Not Modified";
    case 305: return ""+getCode()+" Use Proxy Deprecated";
    case 306: return ""+getCode()+" unused";
    case 307: return ""+getCode()+" Temporary Redirect";
    case 308: return ""+getCode()+" Permanent Redirect";
    case 400: return ""+getCode()+" Bad Request";
    case 401: return ""+getCode()+" Unauthorized";
    case 402: return ""+getCode()+" Payment Required";
    case 403: return ""+getCode()+" Forbidden";
    case 404: return ""+getCode()+" Not Found";
    case 405: return ""+getCode()+" Method Not Allowed";
    case 406: return ""+getCode()+" Not Acceptable";
    case 407: return ""+getCode()+" Proxy Authentication Required";
    case 408: return ""+getCode()+" Request Timeout";
    case 409: return ""+getCode()+" Conflict";
    case 410: return ""+getCode()+" Gone";
    case 411: return ""+getCode()+" Length Required";
    case 412: return ""+getCode()+" Precondition Failed";
    case 413: return ""+getCode()+" Content Too Large";
    case 414: return ""+getCode()+" URI Too Long";
    case 415: return ""+getCode()+" Unsupported Media Type";
    case 416: return ""+getCode()+" Range Not Satisfiable";
    case 417: return ""+getCode()+" Expectation Failed";
    case 418: return ""+getCode()+" I'm a teapot";
    case 421: return ""+getCode()+" Misdirected Request";
    case 422: return ""+getCode()+" Unprocessable Content";
    case 423: return ""+getCode()+" Locked";
    case 424: return ""+getCode()+" Failed Dependency";
    case 425: return ""+getCode()+" Too Early Experimental";
    case 426: return ""+getCode()+" Upgrade Required";
    case 428: return ""+getCode()+" Precondition Required";
    case 429: return ""+getCode()+" Too Many Requests";
    case 431: return ""+getCode()+" Request Header Fields Too Large";
    case 451: return ""+getCode()+" Unavailable For Legal Reasons";
    case 500: return ""+getCode()+" Internal Server Error";
    case 501: return ""+getCode()+" Not Implemented";
    case 502: return ""+getCode()+" Bad Gateway";
    case 503: return ""+getCode()+" Service Unavailable";
    case 504: return ""+getCode()+" Gateway Timeout";
    case 505: return ""+getCode()+" HTTP Version Not Supported";
    case 506: return ""+getCode()+" Variant Also Negotiates";
    case 507: return ""+getCode()+" Insufficient Storage";
    case 508: return ""+getCode()+" Loop Detected";
    case 510: return ""+getCode()+" Not Extended";
    case 511: return ""+getCode()+" Network Authentication Required";
    default: return "HTTP code "+code;
    }
  }
}