import com.servico.MensagemServico;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author osmar
 */
public class Principal {

    public static void main(String[] args) {
        try {
            //Especifica o endereço do servidor do serviço
            URL url = new URL("http://localhost:8080/webservice_calculadora_jaxws_soap_tomcat/MensagemServico?wsdl");
            //Valores fornecidos pela WSDL
            //1o parâmetro usar valor do atributo namespace da tag binding\operation\input\soap do wsdl
            //Classe de implementação acrescida de "service
            //2o parâmetro usar valor do atributo name(URI) da tag service do wsdl
            QName qName = new QName("http://servico.com/", "MensagemServicoImplService");
            //Cria o serviço e retorna uma referência do objeto
            Service servico = Service.create(url, qName);
            //Especifica o objeto pelo qual podemos invocar operações
            MensagemServico mensagemServico = servico.getPort(MensagemServico.class);
            // Chamando os métodos remoto para alterar a mensagem
            mensagemServico.setMensagem("Teste");            
            System.out.println(mensagemServico.getMensagem());

        } catch (MalformedURLException mue) {
            System.out.println("Excecao :" + mue.getMessage());
        }
    }
}