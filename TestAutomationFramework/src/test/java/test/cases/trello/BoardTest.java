package test.cases.trello;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class BoardTest extends BaseTest {

    @Test
    public void test_1_createBoardWhenCreateBoardClicked() {

        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertListExists("To Do");

    }

    @Test
    public void test_2_createNewCardInExistingBoardWhenCreateCardClicked() {

        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.clickOnBoard("My First Board");
        boardPage.addCardToList();

        String cardName = getUIMappingByKey("trello.cardName");
        boardPage.assertCardExists(cardName);

    }

    @Test
    public void test_3_moveCardBetweenStatesWhenDragAndDropIsUsed() throws InterruptedException {

        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.clickOnBoard("My First Board");
        boardPage.moveCardToList();

        boardPage.assertDragAndDrop("Doing", "My First Card");


    }

    @Test
    public void test_4_deleteBoardWhenDeleteButtonIsClicked() {

        login();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.clickOnBoard("My First Board");
        boardPage.deleteBoard();

        boardPage.assertBoardIsDeleted("My First Board");

    }
}
