package pt.inevo.encontra.extract.xmp;

import com.adobe.xmp.XMPConst;

/**
 * Namespace:  "http://iptc.org/std/Iptc4xmpCore/1.0/xmlns/"
 * The preferred schema namespace prefix is Iptc4xmpCore
 */
public class IptcXMPFields {

    /**
     * XMP Iptc main namespace URI.
     */
    public static String NS_URI = XMPConst.NS_IPTCCORE;

    /**
     * XMP Iptc specific namespace prefix.
     */
    public static String NS_PREFIX = "Iptc4xmpCore" + XMPUtil.XMP_SEPARATOR;

    public static String INTELLECTUAL_GENRE = NS_PREFIX + "IntellectualGenre";

    public static String LOCATION = NS_PREFIX + "Location";

    public static String COUNTRY_CODE = NS_PREFIX + "CountryCode";

    public static String CREATOR_CONTACT_ADR_CITY = NS_PREFIX + "CiAdrCity";

    public static String CREATOR_CONTACT_ADR_REGION = NS_PREFIX + "CiAdrRegion";

    public static String CREATOR_CONTACT_ADR_EXTADR = NS_PREFIX + "CiAdrExtadr";

    public static String CREATOR_CONTACT_ADR_PCODE = NS_PREFIX + "CiAdrPcode";

    public static String CREATOR_CONTACT_ADR_CTRY = NS_PREFIX + "CiAdrCtry";

    public static String CREATOR_CONTACT_TEL_WORK = NS_PREFIX + "CiTelWork";

    public static String CREATOR_CONTACT_EMAIL_WORK = NS_PREFIX + "CiEmailWork";

    public static String CREATOR_CONTACT_URL_WORK = NS_PREFIX + "CiUrlWork";

    public static String SCENE = NS_PREFIX + "Scene";

    public static String SUBJECT_CODE = NS_PREFIX + "SubjectCode";
}
