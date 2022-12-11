package org.example;

public class Content {
    private ContentType contentType;

    public Content(ContentType contentType) {
        switch (contentType) {
            case Video:
                setContentType(contentType);
                break;
            case Voice:
                setContentType(contentType);
                break;
            case Text:
                setContentType(contentType);
                break;
            case ShortVideo:
                setContentType(contentType);
                break;
        }
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }
}
