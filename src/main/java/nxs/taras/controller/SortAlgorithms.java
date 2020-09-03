package nxs.taras.controller;

import nxs.taras.sort.Sort;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class SortAlgorithms {
    private HashMap<Class<? extends Sort>, Sort> sortAlgorithms;

    public SortAlgorithms() {
        sortAlgorithms = new HashMap<>();
        Reflections reflections = new Reflections("nxs/taras/sort");
        for (Class<? extends Sort> clazz : reflections.getSubTypesOf(Sort.class)) {
            try {
                sortAlgorithms.put(clazz, clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> getAlgorithmsNames() {
        return sortAlgorithms.keySet().stream().map(Class::getSimpleName).collect(Collectors.toCollection(ArrayList::new));
    }

    public Sort getSortAlgorithm(Class<? extends  Sort> sortClass) {
        return sortAlgorithms.get(sortClass);
    }

    public Sort getSortAlgorithm(String className) throws ClassNotFoundException {
        return sortAlgorithms.get(Class.forName("nxs.taras.sort." + className));
    }

}
