package com.example.freshupnew.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ServicesListModel {

    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("details")
    @Expose
    private List<GetServicesDataModel.Detail> details = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GetServicesDataModel.Detail> getDetails() {
        return details;
    }

    public void setDetails(List<GetServicesDataModel.Detail> details) {
        this.details = details;
    }

    public static class SubSubService {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("serviceId")
        @Expose
        private String serviceId;
        @SerializedName("subServiceId")
        @Expose
        private String subServiceId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("frenchTitle")
        @Expose
        private String frenchTitle;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("updated")
        @Expose
        private String updated;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public String getSubServiceId() {
            return subServiceId;
        }

        public void setSubServiceId(String subServiceId) {
            this.subServiceId = subServiceId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFrenchTitle() {
            return frenchTitle;
        }

        public void setFrenchTitle(String frenchTitle) {
            this.frenchTitle = frenchTitle;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

    }



    public static class Detail {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("serviceId")
        @Expose
        private String serviceId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("frenchTitle")
        @Expose
        private String frenchTitle;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("updated")
        @Expose
        private String updated;
        @SerializedName("subSubServices")
        @Expose
        private List<GetServicesDataModel.SubSubService> subSubServices = null;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFrenchTitle() {
            return frenchTitle;
        }

        public void setFrenchTitle(String frenchTitle) {
            this.frenchTitle = frenchTitle;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public List<GetServicesDataModel.SubSubService> getSubSubServices() {
            return subSubServices;
        }

        public void setSubSubServices(List<GetServicesDataModel.SubSubService> subSubServices) {
            this.subSubServices = subSubServices;
        }

    }
}
