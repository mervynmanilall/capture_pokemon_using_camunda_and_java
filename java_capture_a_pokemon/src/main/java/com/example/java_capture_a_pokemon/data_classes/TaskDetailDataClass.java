package com.example.java_capture_a_pokemon.data_classes;

public class TaskDetailDataClass {
    private String id;
    private String name;
    private String assignee = null;
    private String created;
    private String due = null;
    private String followUp = null;
    private String lastUpdated = null;
    private String delegationState = null;
    private String description = null;
    private String executionId;
    private String owner = null;
    private String parentTaskId = null;
    private float priority;
    private String processDefinitionId;
    private String processInstanceId;
    private String taskDefinitionKey;
    private String caseExecutionId = null;
    private String caseInstanceId = null;
    private String caseDefinitionId = null;
    private boolean suspended;
    private String formKey = null;
    private String camundaFormRef = null;
    private String tenantId = null;


    // Getter Methods

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getCreated() {
        return created;
    }

    public String getDue() {
        return due;
    }

    public String getFollowUp() {
        return followUp;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getDelegationState() {
        return delegationState;
    }

    public String getDescription() {
        return description;
    }

    public String getExecutionId() {
        return executionId;
    }

    public String getOwner() {
        return owner;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public float getPriority() {
        return priority;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public String getCaseExecutionId() {
        return caseExecutionId;
    }

    public String getCaseInstanceId() {
        return caseInstanceId;
    }

    public String getCaseDefinitionId() {
        return caseDefinitionId;
    }

    public boolean getSuspended() {
        return suspended;
    }

    public String getFormKey() {
        return formKey;
    }

    public String getCamundaFormRef() {
        return camundaFormRef;
    }

    public String getTenantId() {
        return tenantId;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setDelegationState(String delegationState) {
        this.delegationState = delegationState;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public void setPriority(float priority) {
        this.priority = priority;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public void setCaseExecutionId(String caseExecutionId) {
        this.caseExecutionId = caseExecutionId;
    }

    public void setCaseInstanceId(String caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }

    public void setCaseDefinitionId(String caseDefinitionId) {
        this.caseDefinitionId = caseDefinitionId;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public void setCamundaFormRef(String camundaFormRef) {
        this.camundaFormRef = camundaFormRef;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}

