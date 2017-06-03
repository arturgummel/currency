package ee.procedure;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Arrays;

@JacksonXmlRootElement(localName = "Envelope", namespace = "gesmes")
class Envelop {

    @JacksonXmlProperty(localName = "subject", namespace = "gesmes")
    private String subject;

    @JacksonXmlProperty(localName = "Sender", namespace = "gesmes")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Sender sender;

    @JacksonXmlProperty(localName = "Cube")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Cube cube;

    public Envelop() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"subject\":\"" + subject + "\"" +
                "," + sender +
                "," + cube +
                "}";
    }
}

class Sender {

    public Sender() {
    }

    @JacksonXmlProperty(localName = "name", namespace = "gesmes")
    private String name;

    @Override
    public String toString() {
        return "\"name\":\"" + name + "\"";
    }
}

class Cube {

    public Cube() {
    }

    @JacksonXmlProperty(localName = "Cube")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Cube_ cube;

    @Override
    public String toString() {
        return cube.toString();
    }
}

class Cube_ {

    public Cube_() {
    }

    @JacksonXmlProperty(isAttribute = true)
    private String time;

    @JacksonXmlProperty(localName = "Cube")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Cube__[] cube;

    @Override
    public String toString() {
        return "\"time\":\"" + time + "\"" +
                ", \"Currencies\":" + Arrays.toString(cube);
    }
}

class Cube__ {

    public Cube__() {
    }

    @JacksonXmlProperty(localName = "rate", isAttribute = true)
    private String rate;

    @JacksonXmlProperty(localName = "currency", isAttribute = true)
    private String currency;

    @Override
    public String toString() {
        return "{" +
                "\"rate\":\"" + rate + "\"" +
                ",\"currency\":\"" + currency + "\"" +
                '}';
    }
}

