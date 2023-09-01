    package pages.trello;

    import org.junit.Assert;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;

    import java.util.List;

    import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

    public class BoardPage extends BaseTrelloPage {

        public BoardPage(WebDriver driver) {
            super(driver, "trello.boardPage");
        }

        public void addCardToList() {

            String nameCard = getUIMappingByKey("trello.cardName");
            String textArea = getUIMappingByKey("trello.boardsPage.cardTextAreaField");

            actions.waitForElementClickable("trello.boardsPage.addCardTitle");
            actions.clickElement("trello.boardsPage.addCardTitle");
            actions.waitForElementClickable("trello.boardsPage.cardTextAreaField");
            actions.clickElement("trello.boardsPage.cardTextAreaField");

            actions.waitForElementVisible("trello.boardsPage.cardTextAreaField");
            actions.typeValueInField(nameCard, "trello.boardsPage.cardTextAreaField");
            actions.waitForElementClickable("trello.boardsPage.addCardButton");
            actions.clickElement("trello.boardsPage.addCardButton");
        }

        public void moveCardToList() throws InterruptedException {

            actions.waitForElementPresent("trello.boardPage.sourceCardXpath");
            actions.waitForElementPresent("trello.boardPage.targetListXpath");

            actions.dragAndDropByXpath("trello.boardPage.sourceCardXpath", "trello.boardPage.targetListXpath");
        }

        public void deleteBoard() {

            actions.waitForElementClickable("trello.boardPage.boardActionMenu");
            actions.clickElement("trello.boardPage.boardActionMenu");

            actions.waitForElementClickable("trello.boardPage.boardCloseButton");
            actions.clickElement("trello.boardPage.boardCloseButton");

            actions.waitForElementClickable("trello.boardPage.boardCloseRedButton");
            actions.clickElement("trello.boardPage.boardCloseRedButton");

            actions.waitForElementClickable("trello.boardPage.boardPermanentlyDeleteBoardButton");
            actions.clickElement("trello.boardPage.boardPermanentlyDeleteBoardButton");

            actions.waitForElementClickable("trello.boardPage.DeleteBoardConfirmButtonXpath");
            actions.clickElement("trello.boardPage.DeleteBoardConfirmButtonXpath");

        }

        public void createList(String listName) {
            actions.waitForElementPresent("trello.boardPage.listNameInput");
            actions.typeValueInField(listName, "trello.boardPage.listNameInput");
            actions.clickElement("trello.boardPage.addListButton");
        }

        public void createDefaultLists() {
            createList(getUIMappingByKey("trello.listNameToDo"));
            createList(getUIMappingByKey("trello.listNameDoing"));
            createList(getUIMappingByKey("trello.listNameDone"));
        }

        public void assertListExists(String listName) {

            actions.waitForElementPresent("trello.boardPage.listByName", listName);

        }

        public void assertCardExists(String cardName) {

            String cardXpath = String.format(getUIMappingByKey("trello.boardPage.spanCardName"), cardName);
            actions.waitForElementPresent(cardXpath);
        }

        public void clickOnBoard(String boardName) {

            actions.waitForElementVisible("trello.boardsPage.boardByTeamAndName", boardName);
            actions.clickElement("trello.boardsPage.boardByTeamAndName", boardName);

        }

        public void assertDragAndDrop(String listName, String cardName) {

            actions.waitForElementPresent("trello.boardPage.cardUnderList", listName, cardName);

        }

        public void assertBoardIsDeleted(String boardName) {

            Assert.assertFalse("Board is not deleted", actions.isElementPresent("trello.boardPage.deleteBoardAssertions", boardName));

        }
    }
