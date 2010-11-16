
/*
 * Copyright (c) 2010 - DeepaMehta e.V.
 *
 * This file is part of deepamehta3-audi-0h-canvas-model
 *
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License version 3 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * version 3 for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * version 3 along with this work. If not, see <http://www.gnu.org/licenses/>.
 */

package de.deepamehta.plugins.multiclient.migrations;

import de.deepamehta.core.model.DataField;
import de.deepamehta.core.model.TopicType;
import de.deepamehta.core.service.Migration;


/**
 * Introducing some datafields to distinct various origins of a file resource and attach meta information to such.
 * 
 * @author Malte Reißig - (malte@deepamehta.org) - http://github.com/mukil -
 * @modified Nov 3, 2010
 * @website http://github.com/mukil/dm3-audio-canvas-model
 * 
 * Distributed with the deepameht3-fxcanvas
 */
 
public class Migration1 extends Migration {
    
    @Override
    public void run() {
        createAudioOriginProperty();
    }

    // ---

    private void createAudioOriginProperty() {
        TopicType file = dms.getTopicType("de/deepamehta/core/topictype/File", null);
        // 
        DataField audioVendorField = new DataField("Origin", "text");
        audioVendorField.setUri("org/deepamehta/audio/property/Origin");
        audioVendorField.setLabel("Origin");
        audioVendorField.setRendererClass("TextFieldRenderer");
        audioVendorField.setEditor("single line");
        audioVendorField.setIndexingMode("KEY");
        file.addDataField(audioVendorField);
        //
        DataField originIdField = new DataField("OriginId", "text");
        originIdField.setUri("org/deepamehta/audio/property/OriginId");
        originIdField.setLabel("OriginId");
        originIdField.setRendererClass("TextFieldRenderer");
        originIdField.setEditor("single line");
        originIdField.setIndexingMode("KEY");
        file.addDataField(originIdField);
        //
        DataField previewImageField = new DataField("PreviewImage", "text");
        previewImageField.setUri("org/deepamehta/audio/property/PreviewImage");
        previewImageField.setLabel("PreviewImage");
        previewImageField.setRendererClass("TextFieldRenderer");
        previewImageField.setEditor("single line");
        previewImageField.setIndexingMode("KEY");
        file.addDataField(previewImageField);
        //
        DataField artworkUrl = new DataField("Artwork", "html");
        artworkUrl.setUri("org/deepamehta/audio/property/Artwork");
        artworkUrl.setLabel("Artwork");
        artworkUrl.setRendererClass("HTMLFieldRenderer");
        artworkUrl.setIndexingMode("FULLTEXT_KEY");
        file.addDataField(artworkUrl);
        //
        DataField audioDescription = new DataField("Description", "text");
        audioDescription.setUri("org/deepamehta/audio/property/Description");
        audioDescription.setLabel("Description");
        audioDescription.setEditor("single line");
        audioDescription.setRendererClass("TextFieldRenderer");
        audioDescription.setIndexingMode("FULLTEXT");
        file.addDataField(audioDescription);
        //
        DataField publisherAlias = new DataField("Publisher", "text");
        publisherAlias.setUri("org/deepamehta/audio/property/Publisher");
        publisherAlias.setLabel("Publisher");
        publisherAlias.setEditor("single line");
        publisherAlias.setRendererClass("TextFieldRenderer");
        publisherAlias.setIndexingMode("KEY");
        file.addDataField(publisherAlias);
    }
}
