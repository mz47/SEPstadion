
package login;

import javax.faces.context.FacesContext;

public abstract class auth {
    
    public static String logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("username");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("password");
        return "/Success.xhtml?faces-redirect=true&type=logout";
    }
    public static String redirect()
    {
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username") != null)
        {
            return "Backend";
        }
        else
        {
            return "login";
        }
    }
    public static boolean isAuth()
    {
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username") != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static String auth()
    {
        String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        String password = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("password");

        if (utils.md5.toMd5(username).equals("314e9e118b3026ce64b768b84a22d816") && utils.md5.toMd5(password).equals("923c88ea6ba552667a36dc44601fcfbf"))
        {
            return "Backend";
        }
        else
        {
            return "/Error.xhtml?faces-redirect=true&type=auth";
        }
    }
}
