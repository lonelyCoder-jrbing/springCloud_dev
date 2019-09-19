package com.yh.businessDelegate;

public class App {

  public static void main(String[] args) {

    BusinessDelegate businessDelegate = new BusinessDelegate();
    Client client = new Client(businessDelegate);
    businessDelegate.setServiceType(ServiceType.EJB);
    ServiceLookUp serviceLookUp = new ServiceLookUp();
    serviceLookUp.setEjbService(new EjbService());
    serviceLookUp.setJmsService(new JmsService());
    serviceLookUp.setServiceType(ServiceType.EJB);
    businessDelegate.setServiceLookUp(serviceLookUp);
    client.doTask();
  }

}
