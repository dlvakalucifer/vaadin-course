package dev.vaadin.udemy_course.view.binder;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.router.Route;
import dev.vaadin.udemy_course.model.Person;

// http://localhost:8080/person-form
@Route("person-form")
public class PersonView extends VerticalLayout
{
    private Person person;

    public PersonView()
    {
        person = loadDefaultPerson();
        loadDefaultPerson();
        setSizeFull();
        createForm();
    }

    private Person loadDefaultPerson()
    {
        Person person = new Person();
        person.setName("John");
        person.setMobile("01712182927");
        person.setAddress("Some Fancy Place");
        person.setAge(30);
        person.setEmail("John@Domain.com");

        return person;
    }

    private void createForm()
    {

        var formLayout = new FormLayout();
        formLayout.setWidth("100%");
        formLayout.setHeight("100%");

        var tfName = new TextField("Name");
        var tfMobile = new TextField("Mobile");
        var tfAddress = new TextField("Address");
        var tfEmail = new TextField("Email");
        var tfAge = new TextField("Age");

        var horizontalLayout = new HorizontalLayout();

        var btSave = new Button("Save");
        var btCancel = new Button("Cancel");

        var binder = new Binder<>(Person.class);
        binder.forField(tfName).bind(Person::getName, Person::setName);
        binder.forField(tfMobile).bind(Person::getMobile, Person::setMobile);
        binder.forField(tfAddress).bind(Person::getAddress, Person::setAddress);
        binder.forField(tfAge).withConverter(new StringToIntegerConverter("not an age")).bind(Person::getAge, Person::setAge);
        binder.forField(tfEmail).bind(Person::getEmail, Person::setEmail);


        horizontalLayout.add(btSave, btCancel);

        formLayout.add(tfName, tfMobile, tfAge, tfAddress, tfEmail, horizontalLayout);

        add(formLayout);

        binder.readBean(person);

        btSave.addClickListener( e -> {
            try
            {
                binder.writeBean(person);
                Notification.show(person.toString(), 5000 ,Notification.Position.TOP_CENTER);
            } catch (ValidationException ex)
            {
                Notification.show("Save not successful", 5000 ,Notification.Position.TOP_CENTER);
            }
        });
    }
}
