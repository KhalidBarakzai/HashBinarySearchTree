//Khali081
class HBSTDriver
{
    private final static String[] keys =
            { "net",     "tray",       "sentence",     "clean",
                    "folk",         "brief",        "throw",       "don't",
                    "pen",        "rant",       "front",    "stop",
                    "deliver",      "third",       "deadend",        "me",
                    "hence",        "exact",        "progress",     "now",
                    "change",     "goat",         "is",          "I'm",
                    "fun",       "even",            "clark",         "having",
                    "net",         "steven",       "ark",         "such",
                    "papi",      "duty",      "park",            "a",
                    "second",       "long",        "hello",      "good",
                    "hint",       "unrecognizable", "violate",        "time",
                    "fence",       "transparent",    "teal",        "ball",
                    "box",          "doing",         "peal",    "call" };

    public static void main(String [] args)
    {
        HBST<String, Integer> hbst = new HBST<String, Integer>();
        System.out.println(hbst.isEmpty()); //True
        for (int i = 0; i < keys.length; i++)
        {
            hbst.put(keys[i], i);
        }
        System.out.println(hbst.height());//Print Height
        for (int i = 0; i < keys.length; i++)
        {
            System.out.format("%02d %s", hbst.get(keys[i]), keys[i]);
            System.out.println();//Print key and value of each index
        }

        System.out.println(hbst.isEmpty());//False
    }
}

//OUTPUT BELOW
/*
        true
        12
        00 net
        01 tray
        02 sentence
        03 clean
        04 folk
        05 brief
        06 throw
        07 don't
        08 pen
        09 rant
        10 front
        11 stop
        12 deliver
        13 third
        14 deadend
        15 me
        16 hence
        17 exact
        18 progress
        19 now
        20 change
        21 goat
        22 is
        23 I'm
        24 fun
        25 even
        26 clark
        27 having
        00 net
        29 steven
        30 ark
        31 such
        32 papi
        33 duty
        34 park
        35 a
        36 second
        37 long
        38 hello
        39 good
        40 hint
        41 unrecognizable
        42 violate
        43 time
        44 fence
        45 transparent
        46 teal
        47 ball
        48 box
        49 doing
        50 peal
        51 call
        false
*/
