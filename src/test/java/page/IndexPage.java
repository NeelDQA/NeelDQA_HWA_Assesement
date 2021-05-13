package page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
	@FindBy(xpath = "//*[@id=\"title\"]")
	private WebElement createTitle;

	@FindBy(id = "artist")
	private WebElement createArtist;

	@FindBy(id = "label")
	private WebElement createLabel;

	@FindBy(id = "year")
	private WebElement createYear;

	@FindBy(id = "genre")
	private WebElement createGenre;

	@FindBy(id = "key")
	private WebElement createKey;

	@FindBy(id = "submit")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id=\"songTable\"]/thead/tr[2]/td[8]/button")
	private WebElement editButton;

	@FindBy(xpath = "//*[@id=\"songTable\"]/thead/tr[2]/td[9]/button")
	private WebElement deleteButton;

	@FindBy(xpath = "//*[@id=\"modalTitle\"]")
	private WebElement updateTitle;

	@FindBy(id = "modalArtist")
	private WebElement updateArtist;

	@FindBy(id = "modalLabel")
	private WebElement updateLabel;

	@FindBy(id = "modalYear")
	private WebElement updateYear;

	@FindBy(id = "modalGenre")
	private WebElement updateGenre;

	@FindBy(id = "modalKey")
	private WebElement updateKey;

	@FindBy(xpath = "/html/body/div/div[2]/div/div/div[2]/div[2]/button[2]")
	private WebElement updateSong;

	@FindBy(xpath = "//*[@id=\"songTable\"]/thead/tr[2]/td[2]")
	private WebElement readTitle;

	@FindBy(xpath = "//*[@id=\"songTable\"]/thead/tr[2]/td[3]")
	private WebElement readArtist;

	@FindBy(xpath = "//*[@id=\"songTable\"]/thead/tr[2]/td[4]")
	private WebElement readLabel;

	@FindBy(xpath = "//*[@id=\"songTable\"]/thead/tr[2]/td[5]")
	private WebElement readKey;

	@FindBy(xpath = "//*[@id=\"songTable\"]/thead/tr[2]/td[6]")
	private WebElement readGenre;

	@FindBy(xpath = "//*[@id=\"songTable\"]/thead/tr[2]/td[7]")
	private WebElement readYear;
	
	
	@FindBy(xpath = "//*[@id=\"updateModal\"]/div/div/div[2]/div[2]/button[1]")
	private WebElement closeModal;
	
	@FindBy (xpath = "//*[@id=\"updateModal\"]/div/div/div[1]/button")
	private WebElement exitModalCross;
	
	@FindBy (id = "updateModal")
	private WebElement openModal;




	public void create(String title, String artist, String label, String year, String genre, String key) {
		createTitle.click();
		createTitle.sendKeys(title);
		createArtist.click();
		createArtist.sendKeys(artist);
		createLabel.click();
		createLabel.sendKeys(label);
		createYear.click();
		createYear.sendKeys(year);
		createGenre.click();
		createGenre.sendKeys(genre);
		createKey.click();
		createKey.sendKeys(key);
		getSubmitButton().click();

	}

	public void update(String title, String artist, String label, String year, String genre, String key) {
//		getEditButton().click();

		updateTitle.click();
		updateTitle.sendKeys(title);

		updateArtist.click();
		updateArtist.sendKeys(artist);

		updateLabel.click();
		updateLabel.sendKeys(label);

		updateYear.click();
		updateYear.sendKeys(year);

		updateGenre.click();
		updateGenre.sendKeys(genre);

		updateKey.click();
		updateKey.sendKeys(key);

		

	}

	public WebElement getReadTitle() {
		return readTitle;
	}

	public WebElement getReadArtist() {
		return readArtist;
	}

	public WebElement getReadLabel() {
		return readLabel;
	}

	public WebElement getReadYear() {
		return readYear;
	}

	public WebElement getReadGenre() {
		return readGenre;
	}

	public WebElement getReadKey() {
		return readKey;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getUpdateTitle() {
		return updateTitle;
	}

	public WebElement getUpdateArtist() {
		return updateArtist;
	}

	public WebElement getUpdateLabel() {
		return updateLabel;
	}

	public WebElement getUpdateYear() {
		return updateYear;
	}

	public WebElement getUpdateGenre() {
		return updateGenre;
	}

	public WebElement getUpdateKey() {
		return updateKey;
	}

	public WebElement getUpdateSong() {
		return updateSong;
	}

	public void submit() {
		getSubmitButton().click();
	}

	public WebElement getCreateTitle() {
		return createTitle;
	}

	public WebElement getCreateArtist() {
		return createArtist;
	}

	public WebElement getCreateLabel() {
		return createLabel;
	}

	public WebElement getCreateYear() {
		return createYear;
	}

	public WebElement getCreateGenre() {
		return createGenre;
	}

	public WebElement getCreateKey() {
		return createKey;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

}
