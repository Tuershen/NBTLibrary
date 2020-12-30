package com.tuershen.nbtlibrary.minecraft.nbt;

import com.tuershen.nbtlibrary.annotation.TagAnnotation;

import java.io.Serializable;


public class TagString extends TagBase implements Serializable {

        private static final long serialVersionUID = -7806371491641299413L;

        private String data;

        public TagString(String data) {
                this.data = data;
        }

        public TagString() {

        }

        public String getData() {
                return data;
        }

        @TagAnnotation(tagType = "string")
        public void setData(String data) {
                this.data = data;
        }

        @Override
        public String toString() {
                return "TagString{data='" + data + "}";
        }

        @Override
        public Object data() {
                return this.data;
        }

        @Override
        public byte getTypeId() {
                return 8;
        }
}
