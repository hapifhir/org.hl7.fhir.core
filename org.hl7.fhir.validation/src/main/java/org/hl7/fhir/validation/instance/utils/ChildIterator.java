package org.hl7.fhir.validation.instance.utils;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.utilities.Utilities;

public class ChildIterator {
    private final InstanceValidator instanceValidator;
    private String basePath;
    private Element parent;
    private int cursor;
    private int lastCount;

    public ChildIterator(InstanceValidator instanceValidator, String path, Element element) {
        this.instanceValidator = instanceValidator;
        parent = element;
        basePath = path;
        cursor = -1;
    }

    public InstanceValidator getInstanceValidator() {
        return instanceValidator;
    }

    public String getBasePath() {
        return basePath;
    }

    public ChildIterator setBasePath(String basePath) {
        this.basePath = basePath;
        return this;
    }

    public Element getParent() {
        return parent;
    }

    public ChildIterator setParent(Element parent) {
        this.parent = parent;
        return this;
    }

    public int getCursor() {
        return cursor;
    }

    public ChildIterator setCursor(int cursor) {
        this.cursor = cursor;
        return this;
    }

    public int getLastCount() {
        return lastCount;
    }

    public ChildIterator setLastCount(int lastCount) {
        this.lastCount = lastCount;
        return this;
    }

    public Element element() {
        return parent.getChildren().get(cursor);
    }

    public String name() {
        return element().getName();
    }

    public int count() {
        String nb = cursor == 0 ? "--" : parent.getChildren().get(cursor - 1).getName();
        String na = cursor >= parent.getChildren().size() - 1 ? "--" : parent.getChildren().get(cursor + 1).getName();
        if (name().equals(nb) || name().equals(na)) {
            return lastCount;
        } else
            return -1;
    }

    public boolean next() {
        if (cursor == -1) {
            cursor++;
            lastCount = 0;
        } else {
            String lastName = name();
            cursor++;
            if (cursor < parent.getChildren().size() && name().equals(lastName))
                lastCount++;
            else
                lastCount = 0;
        }
        return cursor < parent.getChildren().size();
    }

    public String path() {
        int i = count();
        String sfx = "";
        String n = name();
        String fn = "";
        if (element().getProperty().isChoice()) {
            String en = element().getProperty().getName();
            en = en.substring(0, en.length() - 3);
            String t = n.substring(en.length());
            if (instanceValidator.isPrimitiveType(Utilities.uncapitalize(t)))
                t = Utilities.uncapitalize(t);
            n = en;
            fn = ".ofType(" + t + ")";
        }
        if (i > -1 || (element().getSpecial() == null && element().isList())) {
            sfx = "[" + Integer.toString(lastCount) + "]";
        }
        return basePath + "." + n + sfx + fn;
    }
}