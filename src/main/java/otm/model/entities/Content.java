package otm.model.entities;

/**
 * The content of a {@link Document}. There are two different options on how the content can be provided. Either through an external link to where the content lives. Or directly as an encoded base64 string.
 */
public class Content {
    /**
     * The type of content this is
     */
    private ContentType contentType;

    /**
     * String link to the content
     */
    private String uri;

    /**
     * The content string for the linked document
     */
    private String raw;

    // Getters and setters

    /**
     * Gets the type of the content.
     *
     * @return The content type.
     */
    public ContentType getContentType() {
        return contentType;
    }

    /**
     * Sets the type of the content.
     *
     * @param contentType The content type to set.
     */
    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    /**
     * Gets the URI (link) to the content.
     *
     * @return The URI of the content.
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the URI (link) to the content.
     *
     * @param uri The URI to set.
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * Gets the raw content string (e.g., base64 encoded).
     *
     * @return The raw content.
     */
    public String getRaw() {
        return raw;
    }

    /**
     * Sets the raw content string (e.g., base64 encoded).
     *
     * @param raw The raw content to set.
     */
    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentType=" + contentType +
                ", uri='" + uri + '\'' +
                ", raw='" + raw + '\'' +
                '}';
    }
}