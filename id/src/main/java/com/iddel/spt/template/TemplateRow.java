package com.iddel.spt.template;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemplateRow {
	
	private Integer cmspkId;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();
	private Map<String,Integer> sqlmetadata;

	 

	public Map<String,Integer> getSqlmetadata() {
		return sqlmetadata;
	}
	
	public void setSqlmetadata(Map<String,Integer> sqlmetadata) {
		this.sqlmetadata = sqlmetadata;
	}
	public TemplateRow() {
		super();
	}

	public TemplateRow(Integer cmspkId, String cpn, String cpnDesc, String mpn,
			String manufacturer, String supplier,
			Map<String, Object> additionalProperties) {
		super();
		this.cmspkId = cmspkId;
		this.additionalProperties = additionalProperties;
	}

	public Integer getCmspkId() {
		return cmspkId;
	}

	public void setCmspkId(Integer cmspkId) {
		this.cmspkId = cmspkId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperties(String name,Object value) {
		//this.additionalProperties = additionalProperties;
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "TemplateRow ["
				+ (cmspkId != null ? "cmspkId=" + cmspkId + ", " : "")
				+ (additionalProperties != null ? "additionalProperties="
						+ additionalProperties : "") + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((additionalProperties == null) ? 0 : additionalProperties
						.hashCode());
		result = prime * result + ((cmspkId == null) ? 0 : cmspkId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemplateRow other = (TemplateRow) obj;
		if (additionalProperties == null) {
			if (other.additionalProperties != null)
				return false;
		} else if (!additionalProperties.equals(other.additionalProperties))
			return false;
		if (cmspkId == null) {
			if (other.cmspkId != null)
				return false;
		} else if (!cmspkId.equals(other.cmspkId))
			return false;
		return true;
	}
	
	
}
