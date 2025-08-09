package dev.vaadin.udemy_course.view.binder;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("person-form")
public class PersonView extends VerticalLayout
{
    public PersonView()
    {
        setSizeFull();
        createForm();
    }

    private void createForm()
    {

    }
}
