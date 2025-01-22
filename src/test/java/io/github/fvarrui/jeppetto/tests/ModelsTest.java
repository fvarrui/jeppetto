package io.github.fvarrui.jeppetto.tests;

import io.github.fvarrui.jeppetto.Jeppetto;
import io.github.fvarrui.jeppetto.api.model.Model;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class ModelsTest {

    private Jeppetto jeppetto;

    @Before
    public void setup() {
        ResourceBundle bundle = ResourceBundle.getBundle("config");
        jeppetto = new Jeppetto(bundle.getString("openai.api.key"));
    }

    @Test
    public void testGetModels() throws IOException {
        List<Model> models = jeppetto.getModels();
        assert models.stream().map(Model::getId).anyMatch(id -> id.equals("gpt-3.5-turbo"));
    }

    @Test
    public void testError() {
        try {
            new Jeppetto("invalid-api-key").getModels();
        } catch (IOException e) {
            assert true;
        }
    }

}
