package com.yh.facade;

import com.yh.facade.DwarvenMineWorker.Action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DwarvenGoldmineFacade {

    private List<DwarvenMineWorker> workers;

    public DwarvenGoldmineFacade() {
        workers = new ArrayList<>();
        workers.add(new DwarvenCartOperator());
        workers.add(new DwarvenGoldDigger());
        workers.add(new DwarvenTunnelDigger());
    }

    public void startNewday() {
        makeActions(workers, Action.WAKE_UP);
    }

    public void digOutGold() {
        makeActions(workers, Action.GO_TO_MINE);
    }

    public void endUpaDay() {
        makeActions(workers, Action.GO_HOME, Action.GO_TO_SLEEP);
    }

    public void makeActions(Collection<DwarvenMineWorker> workers, Action... actions) {
        for (DwarvenMineWorker e : workers) {
            e.action(actions);
        }
    }
}
