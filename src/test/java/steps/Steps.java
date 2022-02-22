package steps;

import java.util.List;

import org.junit.Assert;

import cucumber.api.java.pt.*;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import io.cucumber.datatable.DataTable;
import pages.Page;

@SuppressWarnings("deprecation")
public class Steps {
	
	public Page page = new Page();
	
	@Dado("^que o \"(.*)\" esta aberto$")
	public void que_o_esta_aberto(String arg1) throws Throwable {
		Assert.assertTrue(this.page.verificarPage(arg1));
	}
	
	@Quando("abrir menu Guide")
	public void informar_o_usuario() throws Throwable {
		page.clicarBtnGuide();
	}
	
	@Quando("abrir link Albums Photos")
	public void inserirSenha() throws Throwable {
		page.clicarLinkAlbumsPhotos();
	}
	
	@Então("validar retorno do item de id {int}")
	public void a_ordem_e_gerada(Integer id, DataTable data) throws Throwable {
		JsonArray jsonArray = new JsonParser().parse(page.getAlbuns()).getAsJsonArray();
		JsonObject json = null;
		for (JsonElement jsonElement : jsonArray) {
			if(jsonElement.getAsJsonObject().get("id").getAsInt() == id) {
				json = jsonElement.getAsJsonObject();
				break;
			}
		}
		List<String> campos = data.asList();
		Assert.assertEquals(json.get("title").getAsString(), campos.get(0));
		Assert.assertEquals(json.get("url").getAsString(), campos.get(1));
		Assert.assertEquals(json.get("thumbnailUrl").getAsString(), campos.get(2));
	} 
	
}
