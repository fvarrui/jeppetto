package io.github.fvarrui.jeppetto.tests;

import io.github.fvarrui.jeppetto.Jeppetto;
import io.github.fvarrui.jeppetto.api.models.Model;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ResourceBundle;

public class ModelsTest {

    private Jeppetto jeppetto;

    @Before
    public void setup() {
        jeppetto = new Jeppetto(ResourceBundle.getBundle("config").getString("openai.api.key"));
    }

    @Test
    public void testGetModels() throws Exception {
        List<Model> models = jeppetto.getModels();
        assert models.stream().map(Model::getId).anyMatch("gpt-3.5-turbo"::equals);
    }

    @Test
    public void testErrorInvalidApiKey() {
        try {
            new Jeppetto("invalid-api-key").getModels();
        } catch (Exception e) {
            assert true;
        }
    }

}
