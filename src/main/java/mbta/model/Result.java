
package mbta.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "source",
    "resolvedQuery",
    "speech",
    "action",
    "actionIncomplete",
    "parameters",
    "contexts",
    "metadata",
    "fulfillment",
    "score"
})
public class Result {

    @JsonProperty("source")
    private String source;
    @JsonProperty("resolvedQuery")
    private String resolvedQuery;
    @JsonProperty("speech")
    private String speech;
    @JsonProperty("action")
    private String action;
    @JsonProperty("actionIncomplete")
    private Boolean actionIncomplete;
    @JsonProperty("parameters")
    private Map<String, String> parameters;
    @JsonProperty("contexts")
    private List<Object> contexts = null;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("fulfillment")
    private Fulfillment fulfillment;
    @JsonProperty("score")
    private Integer score;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The source
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The resolvedQuery
     */
    @JsonProperty("resolvedQuery")
    public String getResolvedQuery() {
        return resolvedQuery;
    }

    /**
     * 
     * @param resolvedQuery
     *     The resolvedQuery
     */
    @JsonProperty("resolvedQuery")
    public void setResolvedQuery(String resolvedQuery) {
        this.resolvedQuery = resolvedQuery;
    }

    /**
     * 
     * @return
     *     The speech
     */
    @JsonProperty("speech")
    public String getSpeech() {
        return speech;
    }

    /**
     * 
     * @param speech
     *     The speech
     */
    @JsonProperty("speech")
    public void setSpeech(String speech) {
        this.speech = speech;
    }

    /**
     * 
     * @return
     *     The action
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * 
     * @param action
     *     The action
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * 
     * @return
     *     The actionIncomplete
     */
    @JsonProperty("actionIncomplete")
    public Boolean getActionIncomplete() {
        return actionIncomplete;
    }

    /**
     * 
     * @param actionIncomplete
     *     The actionIncomplete
     */
    @JsonProperty("actionIncomplete")
    public void setActionIncomplete(Boolean actionIncomplete) {
        this.actionIncomplete = actionIncomplete;
    }

    /**
     * 
     * @return
     *     The parameters
     */
    @JsonProperty("parameters")
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * 
     * @param parameters
     *     The parameters
     */
    @JsonProperty("parameters")
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    /**
     * 
     * @return
     *     The contexts
     */
    @JsonProperty("contexts")
    public List<Object> getContexts() {
        return contexts;
    }

    /**
     * 
     * @param contexts
     *     The contexts
     */
    @JsonProperty("contexts")
    public void setContexts(List<Object> contexts) {
        this.contexts = contexts;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     * 
     * @return
     *     The fulfillment
     */
    @JsonProperty("fulfillment")
    public Fulfillment getFulfillment() {
        return fulfillment;
    }

    /**
     * 
     * @param fulfillment
     *     The fulfillment
     */
    @JsonProperty("fulfillment")
    public void setFulfillment(Fulfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    /**
     * 
     * @return
     *     The score
     */
    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    /**
     * 
     * @param score
     *     The score
     */
    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
