package com.example.scheduletask.task;

import com.example.scheduletask.task.People.Action;
import com.sun.crypto.provider.HmacMD5KeyGenerator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MonitorFacade {

  private List<People> peoples;

  public MonitorFacade() {
    peoples = new ArrayList<>();
    peoples.add(new Programmer());
    peoples.add(new Teacher());
  }

  public void wakeup() {
  makeAction(peoples,Action.WAKE_UP);
  }
  public void makeMoney(){
    makeAction(peoples,Action.MAKE_MONEY);
  }
public void sleep(){
    makeAction(peoples,Action.GO_HOME,Action.SLEEP);
}

  public void  makeAction(Collection<People> peoples, Action...actions){
    peoples.forEach(e->{
      e.acion(actions);
    });
  }
}
