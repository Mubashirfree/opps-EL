package service;


import model.Layout;

public interface ILayoutValidator {
    /**
     * Returns true if the layout follows architectural rules.
     */
    boolean validate(Layout layout);
}