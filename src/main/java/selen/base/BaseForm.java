package selen.base;

import selen.waits.ExplicitWaits;

public abstract class BaseForm {
    private BaseElement uniqueElement;

    public BaseForm(BaseElement uniqueElement) {
        this.uniqueElement = uniqueElement;
    }

    public ExplicitWaits.EWaitsForm waits() {
        return new ExplicitWaits.EWaitsForm(uniqueElement.getLocator());
    }
}
