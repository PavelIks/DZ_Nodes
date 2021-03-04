package com.example.mynodes.Java;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.ArrayList;

public class NotesXML
{
    private ArrayList<NotesClass> notes;
    public NotesXML()
    {
        notes = new ArrayList<>();
    }

    public ArrayList<NotesClass> getNotes()
    {
        return notes;
    }

    public boolean parse(XmlPullParser xpp)
    {
        boolean status = true;
        NotesClass currentNotesClass = null;
        boolean inEntity = false;
        String textValue = "";
        try
        {
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT)
            {
                String tagName= xpp.getName();
                switch (eventType)
                {
                    case XmlPullParser.START_TAG:
                        {
                            if("node".equalsIgnoreCase(tagName))
                            {
                                inEntity = true;
                                currentNotesClass = new NotesClass();
                            }
                            break;
                        }
                        case XmlPullParser.TEXT:
                        {
                            textValue = xpp.getText();
                            break;
                        }
                        case XmlPullParser.END_TAG:
                        {
                            if(inEntity)
                            {
                                if ("node".equalsIgnoreCase(tagName))
                                {
                                    inEntity = false;
                                    notes.add(currentNotesClass);
                                }
                                else if ("title".equalsIgnoreCase(tagName))
                                {
                                    currentNotesClass.setTitle(textValue);
                                }
                                else if ("body".equalsIgnoreCase(tagName))
                                {
                                    currentNotesClass.setBody(textValue);
                                }
                            }
                            break;
                        }
                }
                eventType = xpp.next();
            }
        }
        catch (XmlPullParserException e)
        {
            status = false;
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return status;
    }
}