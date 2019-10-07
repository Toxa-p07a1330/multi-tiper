package ru.bmstu.iu3;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.Date;
import java.util.EventListener;


public class writer extends WebPage {
  static ExtracterOfInput extracter = new ExtracterOfInput();
  public writer() {
    StatelessForm form = new StatelessForm("form", Model.of(""));
    TextArea textField = new TextArea("text", Model.of(""));
    AjaxButton link = new AjaxButton("link", Model.of(""))
    {
      @Override
      protected void onSubmit(AjaxRequestTarget target) {
        super.onSubmit(target);
          extracter.setStr((String)textField.getValue());
          System.out.println(extracter.getStr());
      }
    };
    form.add(link);
    form.add(textField);
    add(form);
    add(new StatelessLink<Void>("switchMode"){
      @Override
      public void onClick() {
        //we redirect browser to another page.
        setResponsePage(reader.class);
      }
    });
  }
}

class ExtracterOfInput
{
  String str;

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }
}