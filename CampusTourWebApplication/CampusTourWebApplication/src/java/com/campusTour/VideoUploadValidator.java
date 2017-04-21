package com.campusTour;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
 
@FacesValidator(value="videoUploadValidator")
public class VideoUploadValidator implements Validator{
 
    /**
     *
     * @param context
     * @param component
     * @param value
     * @throws ValidatorException
     */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)     throws ValidatorException {
        Part file = (Part) value;
 
        FacesMessage message=null;
 
        try {
 
            if (file==null || file.getSize()<=0 || file.getContentType().isEmpty() )
                message=new FacesMessage("Select a valid file");
            else if (!file.getContentType().endsWith("mp4")) {
                message=new FacesMessage(file.getContentType().endsWith("mp4")+" ");
            } else {
               // message=new FacesMessage("Select a valid format mp4");
            }
//            else if (file.getSize()>2000000)
//                 message=new FacesMessage("File size too big. File size allowed  is less than or equal to 2 MB.");
// 
            if (message!=null && !message.getDetail().isEmpty())
                {
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message );
                }
 
        } catch (Exception ex) {
               throw new ValidatorException(new FacesMessage(ex.getMessage()));
        }
 
    }
 
}