package dev.vaadin.udemy_course.view.components;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("button")
public class ButtonView extends VerticalLayout
{
    public ButtonView()
    {
        var btnClick = new Button("Show");
        btnClick.addClickListener(buttonClickEvent -> Notification.show("Hello World"));

        var btnDoubleClick = new Button("Double");
        btnDoubleClick.addDoubleClickListener(buttonClickEvent -> Notification.show("Double Clicked"));

        var btnSingleClick = new Button("Single");
        btnSingleClick.addSingleClickListener(buttonClickEvent -> Notification.show("Single Clicked"));

        var btnShortcut = new Button("Shortcut ENTER");
        btnShortcut.addClickShortcut(Key.ENTER);
        btnShortcut.addSingleClickListener(buttonClickEvent -> Notification.show("Shortcut Clicked"));

        var btnDisabled = new Button("Disabled on Click");
        btnDisabled.setDisableOnClick(true);
        btnDisabled.addClickListener(buttonClickEvent ->
        {
            Notification.show("Button Disabled on Click");
            try
            {
                Thread.sleep(2500);
            } catch (InterruptedException e)
            {
                Notification.show("interrupted, try again later");
            }
            btnDisabled.setEnabled(true);
            Notification.show("Button Re-enabled");
        });

        var btnTooltip = new Button("Shortcut ENTER");
        btnTooltip.setText("This is a Tooltip");
        btnTooltip.addClickListener(buttonClickEvent -> Notification.show("Clicked"));

        var btnFocus = new Button("Focus");
        btnFocus.addFocusListener(event -> Notification.show("Focused"));

        add(btnClick, btnDoubleClick, btnSingleClick, btnShortcut, btnDisabled, btnTooltip, btnFocus);
    }
}
