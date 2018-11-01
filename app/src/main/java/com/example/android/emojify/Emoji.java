package com.example.android.emojify;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

public enum Emoji {
    //  Use bitwise operations for state.
    //  Little-Endian
    //  0 - 0 - 0
    //  leftEye - rightEye - smiling

    smiling(7),
    frowning(6),
    right_wink(5),
    right_wink_frowning(4),
    left_wink(3),
    left_wink_frowning(2),
    closed_eye_smiling(1),
    closed_eye_frowning(0);

    private int emojiIndex;
    private static final SparseArray<Emoji> lookup = new SparseArray<Emoji>();

    public int getEmojiBitstate() {
        return this.emojiIndex;
    }

    public static Emoji get(int facialState) {
        return lookup.get(facialState);
    }

    static {
        for ( Emoji e : Emoji.values()) {
            lookup.put(e.emojiIndex, e);
        }
    }

    private Emoji(int i) {
        this.emojiIndex = i;
    }
}
