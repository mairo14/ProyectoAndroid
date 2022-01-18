package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ListadoRes extends AppCompatActivity {

    public static ArrayList<Restaurante> listado= new ArrayList<>();
    public static ListView listView;
    public static AdaptadorPersonalizado adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_res);
        listView = findViewById(R.id.Restaurantes);
        ImportRes task =  new ImportRes();
        try {
            task.execute();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public class ImportRes{
        public void execute() throws ParserConfigurationException, SAXException, IOException{



            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(new URL("https://www.esmadrid.com/opendata/restaurantes_v1_es.xml").openStream());
                doc.getDocumentElement().normalize();

                NodeList nodeList = doc.getDocumentElement().getChildNodes();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element elem = (Element) node;
                        String nombre = elem.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();

                        listado.add(new Restaurante(nombre));

                    }
                }
                adaptador = new AdaptadorPersonalizado(ListadoRes.this, listado);
                listado.setAdapter(adaptador);

            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }
}