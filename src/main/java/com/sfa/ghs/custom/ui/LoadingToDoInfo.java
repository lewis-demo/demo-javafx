package com.sfa.ghs.custom.ui;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.sfa.common.exception.SfaException;
import com.sfa.ghs.custom.data.UIEnum;
import com.sfa.ghs.custom.vo.BRItemVO;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class LoadingToDoInfo extends VBox {
	public static final Logger log = Logger.getLogger(LoadingToDoInfo.class);

	@FXML
	private FlowPane uldToDo;
	@FXML
	private FlowPane bulkToDo;

	public LoadingToDoInfo() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(UIEnum.WB_LOADING_TODO_INFO.getFile()));
			fxmlLoader.setRoot(this);
			fxmlLoader.setController(this);
			fxmlLoader.load();
		} catch (IOException e) {
			log.error(e);
			throw new SfaException(e);
		}
	}

	public void initData(List<BRItemVO> vos) {
		for (BRItemVO vo : vos) {
			if (vo.getType().equals("ULD")) {
				UldBox uldBox = new UldBox();
				uldBox.setUldNo(vo.getUldNo());
				uldBox.setWeight(String.valueOf(vo.getWeight()));
				uldBox.setDest(vo.getDest());

				uldToDo.getChildren().add(uldBox);

				uldBox.getStyleClass().add("uldBox");
			} else {
				BulkBox bulkBox = new BulkBox();
				bulkBox.setUldNo(vo.getUldNo());
				bulkBox.setWeight(String.valueOf(vo.getWeight()));
				bulkBox.setDest(vo.getDest());

				bulkToDo.getChildren().add(bulkBox);

				bulkBox.getStyleClass().add("uldBox");
			}
		}
	}
}