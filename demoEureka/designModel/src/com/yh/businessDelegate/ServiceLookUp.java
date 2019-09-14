package com.yh.businessDelegate;

public class ServiceLookUp {

  private JmsService jmsService;
  private EjbService ejbService;
  private ServiceType serviceType;




  public BusinessService getService(ServiceType serviceType) {
    if (this.serviceType.JMS.getName().get().equals(serviceType.getName().get())) {
      return jmsService;
    }else {
      return ejbService;
    }
  }

  public void setJmsService(JmsService jmsService) {
    this.jmsService = jmsService;
  }

  public void setEjbService(EjbService ejbService) {
    this.ejbService = ejbService;
  }

  public void setServiceType(ServiceType serviceType) {
    this.serviceType = serviceType;
  }
}
