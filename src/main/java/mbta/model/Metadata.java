
package mbta.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "intentId",
    "webhookUsed",
    "webhookForSlotFillingUsed",
    "intentName"
})
public class Metadata {

    @JsonProperty("intentId")
    private String intentId;
    @JsonProperty("webhookUsed")
    private String webhookUsed;
    @JsonProperty("webhookForSlotFillingUsed")
    private String webhookForSlotFillingUsed;
    @JsonProperty("intentName")
    private String intentName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The intentId
     */
    @JsonProperty("intentId")
    public String getIntentId() {
        return intentId;
    }

    /**
     * 
     * @param intentId
     *     The intentId
     */
    @JsonProperty("intentId")
    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }

    /**
     * 
     * @return
     *     The webhookUsed
     */
    @JsonProperty("webhookUsed")
    public String getWebhookUsed() {
        return webhookUsed;
    }

    /**
     * 
     * @param webhookUsed
     *     The webhookUsed
     */
    @JsonProperty("webhookUsed")
    public void setWebhookUsed(String webhookUsed) {
        this.webhookUsed = webhookUsed;
    }

    /**
     * 
     * @return
     *     The webhookForSlotFillingUsed
     */
    @JsonProperty("webhookForSlotFillingUsed")
    public String getWebhookForSlotFillingUsed() {
        return webhookForSlotFillingUsed;
    }

    /**
     * 
     * @param webhookForSlotFillingUsed
     *     The webhookForSlotFillingUsed
     */
    @JsonProperty("webhookForSlotFillingUsed")
    public void setWebhookForSlotFillingUsed(String webhookForSlotFillingUsed) {
        this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
    }

    /**
     * 
     * @return
     *     The intentName
     */
    @JsonProperty("intentName")
    public String getIntentName() {
        return intentName;
    }

    /**
     * 
     * @param intentName
     *     The intentName
     */
    @JsonProperty("intentName")
    public void setIntentName(String intentName) {
        this.intentName = intentName;
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
