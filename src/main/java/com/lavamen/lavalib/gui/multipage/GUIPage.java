package com.lavamen.lavalib.gui.multipage;

import com.lavamen.lavalib.gui.singlepage.SinglepageGUI;

public interface GUIPage extends SinglepageGUI {

    /**
     * @return Count number of this page
     */
    int getPage();

    int getNextSlot();

    int getPrevSlot();
}
