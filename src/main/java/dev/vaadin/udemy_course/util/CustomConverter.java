package dev.vaadin.udemy_course.util;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

public class CustomConverter implements Converter<String, Integer>
{
    @Override
    public Result<Integer> convertToModel( String value, ValueContext context )
    {
        try {
            return Result.ok(Integer.parseInt(value));
        } catch (NumberFormatException e)
        {
            return Result.error("Must be a number");
        }
    }

    @Override
    public String convertToPresentation( Integer value, ValueContext context )
    {
        return "" + value;
    }
}
