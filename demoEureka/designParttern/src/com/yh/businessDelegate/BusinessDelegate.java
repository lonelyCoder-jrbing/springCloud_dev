package com.yh.businessDelegate;

public class BusinessDelegate {

  private BusinessService businessService;
  private ServiceType serviceType;
  private ServiceLookUp serviceLookUp;

  public void setServiceType(ServiceType serviceType) {
    this.serviceType = serviceType;
  }

  public void setServiceLookUp(ServiceLookUp serviceLookUp) {
    this.serviceLookUp = serviceLookUp;
  }

  public void doTask(){
    BusinessService service = this.serviceLookUp.getService(this.serviceType);
    service.doProcessing();
  }
}
