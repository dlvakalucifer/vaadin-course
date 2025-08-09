package dev.vaadin.udemy_course.view.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.streams.DownloadHandler;
import com.vaadin.flow.server.streams.FileDownloadHandler;

import java.nio.file.Paths;

@Route("button-style")
public class ButtonStyleView extends VerticalLayout
{
    public ButtonStyleView()
    {
        var btnPrimary = new Button("Primary + Success");
        btnPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);

        var btnSuccess = new Button("Success");
        btnSuccess.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        var btnTertiary = new Button("Tertiary + Success");
        btnTertiary.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SUCCESS);

        var btnIcon = new Button(VaadinIcon.ADOBE_FLASH.create());
        btnIcon.setText("Icon");
        btnIcon.addThemeVariants(ButtonVariant.LUMO_ERROR);

        DownloadHandler resource = new FileDownloadHandler(Paths.get("src/main/resources/static/icons/mylogo.svg").toFile());
        SvgIcon customIcon = new SvgIcon(resource);

        var btnCustomIcon = new Button(customIcon);
        btnCustomIcon.setText("My Custom Icon");
        btnCustomIcon.setIconAfterText(true);
        btnCustomIcon.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_WARNING);

        var btnStyling = new Button("Background Styling");
        btnStyling.getStyle().set("background","green");
        btnStyling.getStyle().set("color","white");

        add(btnPrimary, btnSuccess, btnTertiary, btnIcon, btnCustomIcon, btnStyling);
    }
}
