package android_jb.com.POSD.util;

import android.util.Log;

/**
 * 功能：处理波斯语与阿拉伯�?
 */
public class BS {

	static byte MAX_CNT_SET1 = 29;
	static byte MAX_CNT_SET2 = 42;
	static byte MAX_CNT_SET3 = 4;
	static byte PERSIAN_AlPHABET_CNT = 6;

	static int POS_LAST = 0;
	static int POS_FIRST = 1; // =1
	static int POS_MIDILE = 2; // =2
	static int POS_ALONE = 3; // =3

	int pUniStr[] = { 0x631, 0x632, 0x648, 0x644, 0x648, 0x634, 0x646, 0x00 };

	// 0x644 特殊字符处理
	static int arabic_specs[][] = { { 0xFEF5, 0xFEF6 }, { 0xFEF7, 0xFEF8 },
			{ 0xFEF9, 0xFEFA }, { 0xFEFB, 0xFEFC }, };

	static int theSet1[] = { // 当前字母前字符组�??
	0x626, 0x628, 0x62a, 0x62b, 0x62c, 0x62d, 0x62e, 0x633, 0x634, 0x635,
			0x636, 0x637, 0x638, 0x639, 0x63a, 0x640, 0x641, 0x642, 0x643,
			0x644, 0x645, 0x646, 0x647, 0x64a, 0x67e, // Persian
			0x686, 0x6a9, 0x6af, 0x6cc, };

	static int theSet2[] = { // 当前字母后字符组�??
	0x622, 0x623, 0x624, 0x625, 0x626, 0x627, 0x628, 0x629, 0x62a, 0x62b,
			0x62c, 0x62d, 0x62e, 0x62f, 0x630, 0x631, 0x632, 0x633, 0x634,
			0x635, 0x636, 0x637, 0x638, 0x639, 0x63a, 0x640, 0x641, 0x642,
			0x643, 0x644, 0x645, 0x646, 0x647, 0x648, 0x649, 0x64a, 0x67e, // Persian
			0x686, 0x698, 0x6a9, 0x6af, 0x6cc, };

	// { 0xfe94, 0xfe93, 0xfe93, 0xfe93 },
	static int Arbic_Position[][] = /* last，first，midile，alone */
	{ { 0xfe80, 0xfe80, 0xfe80, 0xfe80 },/* 0x0621 */
	{ 0xfe82, 0xfe81, 0xfe82, 0xfe81 }, { 0xfe84, 0xfe83, 0xfe84, 0xfe83 },
			{ 0xfe86, 0xfe85, 0xfe86, 0xfe85 },
			{ 0xfe88, 0xfe87, 0xfe88, 0xfe87 },
			{ 0xfe8a, 0xfe8b, 0xfe8c, 0xfe89 },/* 26 */
			{ 0xfe8e, 0xfe8d, 0xfe8e, 0xfe8d },
			{ 0xfe90, 0xfe91, 0xfe92, 0xfe8f },
			{ 0xfe94, 0xfe93, 0xfe93, 0xfe93 },
			{ 0xfe96, 0xfe97, 0xfe98, 0xfe95 },
			{ 0xfe9a, 0xfe9b, 0xfe9c, 0xfe99 },
			{ 0xfe9e, 0xfe9f, 0xfea0, 0xfe9d },
			{ 0xfea2, 0xfea3, 0xfea4, 0xfea1 },
			{ 0xfea6, 0xfea7, 0xfea8, 0xfea5 },
			{ 0xfeaa, 0xfea9, 0xfeaa, 0xfea9 },/* 0x062f */
			{ 0xfeac, 0xfeab, 0xfeac, 0xfeab },
			{ 0xfeae, 0xfead, 0xfeae, 0xfead },
			{ 0xfeb0, 0xfeaf, 0xfeb0, 0xfeaf },
			{ 0xfeb2, 0xfeb3, 0xfeb4, 0xfeb1 },
			{ 0xfeb6, 0xfeb7, 0xfeb8, 0xfeb5 },
			{ 0xfeba, 0xfebb, 0xfebc, 0xfeb9 },
			{ 0xfebe, 0xfebf, 0xfec0, 0xfebd },/* 36 */
			{ 0xfec2, 0xfec3, 0xfec4, 0xfec1 },/* 37 */
			{ 0xfec6, 0xfec7, 0xfec8, 0xfec5 },
			{ 0xfeca, 0xfecb, 0xfecc, 0xfec9 },
			{ 0xfece, 0xfecf, 0xfed0, 0xfecd }, { 0x63b, 0x63b, 0x63b, 0x63b },
			{ 0x63c, 0x63c, 0x63c, 0x63c }, { 0x63d, 0x63d, 0x63d, 0x63d },
			{ 0x63e, 0x63e, 0x63e, 0x63e }, { 0x63f, 0x63f, 0x63f, 0x63f },
			{ 0x640, 0x640, 0x640, 0x640 },/* '-' */
			{ 0xfed2, 0xfed3, 0xfed4, 0xfed1 },
			{ 0xfed6, 0xfed7, 0xfed8, 0xfed5 },
			{ 0xfeda, 0xfedb, 0xfedc, 0xfed9 },
			{ 0xfede, 0xfedf, 0xfee0, 0xfedd },
			/* {0x644, 0xfedd, 0xfedf, 0xfee0, 0xfede},dengx add */
			{ 0xfee2, 0xfee3, 0xfee4, 0xfee1 },
			{ 0xfee6, 0xfee7, 0xfee8, 0xfee5 },
			{ 0xfeea, 0xfeeb, 0xfeec, 0xfee9 },
			{ 0xfeee, 0xfeed, 0xfeee, 0xfeed },
			{ 0xfef0, 0xfeef, 0xfef0, 0xfeef },
			{ 0xfef2, 0xfef3, 0xfef4, 0xfef1 },/* 0x64a */
	};

	int Persian_AlphabetTab[][] = // last,first,midile,alone
	{ { 0xfb57, 0xfb58, 0xfb59, 0xfb56 }, // 0x067e
			{ 0xfb7b, 0xfb7c, 0xfb7d, 0xfb7a }, // 0x0686
			{ 0xfb8b, 0xfb8a, 0xfb8b, 0xfb8a }, // 0x0698
			{ 0xfb8f, 0xfb90, 0xfb91, 0xfb8e }, // 0x06a9
			{ 0xfb93, 0xfb94, 0xfb95, 0xfb92 }, // 0x06af
			{ 0xfbfd, 0xfbfe, 0xfbff, 0xfbfc }, // 0x06cc
	};

	// static int dUniStr[] = new int[8];

	/*
	 * 功能�?? 阿拉伯字符串转换(连写) 参数�?? srcWcs. 原始阿拉伯字符串�?? destWcs.
	 * 转换后的阿拉伯字符串�?? 返回�??: 0. 转换失败�?? 1. 转换成功�??
	 */
	@SuppressWarnings("unused")
	public int Arbic_Convert(int srcWcs[], int[] destWcs) {

		int sc[] = srcWcs;
		int i, j, len = sc.length - 1; // // 获取字符串的长度
		Log.i("info", "len == " + len);
		if (len > 0) // 判断字符串的长度
		{
			int destWcss[] = new int[sc.length + 1]; // 动�?�分配内�??
														// （新的字符串）�??

			if (destWcss != null) // 判断内存分配是否成功
			{
				int nCode = 0;
				int wPrevCode, wNextCode;
				int pdsc[] = destWcss;
				int mid_len = len / 2;

				j = 0;
				for (i = 0; i < len; i++) // 循环转换
				{
					wPrevCode = (i == 0) ? 0 : sc[i - 1]; // 获取当前字符的前�??个字符�??
															// （如果当前字符是第一个，则它的前�??个字符为0�??
					// Log.i("info", "wPrevCode === " + wPrevCode);
					wNextCode = (i == len - 1) ? 0 : sc[i + 1]; // 获取当前字符的后�??个字符�??
																// （如果当前字符是�??后一个，则他的后�??个字符为0�??
					// Log.i("info","wNextCode === " + wNextCode);
					nCode = ConvertRule2(wPrevCode, sc[i], wNextCode); // 先按规则2转换�??
					if (nCode == -1) {
						nCode = ConvertRule1(wPrevCode, sc[i], wNextCode); // 先按规则3转换�??
						if (nCode == -1) // 返回-1�?? 转换失败�??
							nCode = ConvertRule3(wPrevCode, sc[i], wNextCode); // 再按规则1转换

					} else
						i++;

					destWcs[j++] = ((nCode != -1) ? nCode : sc[i]); // 如果转换成功（nCode�??=
																	// -1），则nCode为转换后的编码；否则当前编码无需转换，直接赋值�??
				}
				destWcs[j] = 0;

				// 将字节序反向
				// for (i = 0; i < j / 2; i++) {
				// nCode = destWcs[i];
				// destWcs[i] = destWcs[j - i - 1];
				// destWcs[j - i - 1] = nCode;
				// }
				return 1; // 返回成功
			}
		}
		return 0; // 返回失败
	}

	/*
	 * 规则1转换 返回�??: 成功, 返回转换后的编码�?? 失败, 返回 -1.
	 */
	static int ConvertRule1(int wPrevCode, int wCurCode, int wNextCode) {
		if (wCurCode >= 0x621 && wCurCode <= 0x64a) {
			int nPos = POS_ALONE;

			int bLinkPrev = IsLinkPrev(wPrevCode);
			int bLinkNext = IsLinkNext(wNextCode);

			boolean b = false;
			boolean c = false;
			if (bLinkNext == 1) {
				b = true;
			}
			if (bLinkPrev == 1) {
				c = true;
			}

			if (b && c)
				nPos = POS_MIDILE;
			else if (c)
				nPos = POS_LAST;
			else if (b)
				nPos = POS_FIRST;

			return Arbic_Position[wCurCode - 0x621][nPos];
		}

		return -1;
	}

	/*
	 * 规则2转换 返回值： 成功, 返回转换后的编码�?? 失败, 返回 -1.
	 */
	static int ConvertRule2(int wPrevCode, int wCurCode, int wNextCode) {
		if (wCurCode == 0x644) {
			int[] theSet3 = { 0x622, 0x623, 0x625, 0x627 };
			byte i = 0;

			for (i = 0; i < MAX_CNT_SET3; i++) {
				if (theSet3[i] == wNextCode)
					break;
			}
			if (i != MAX_CNT_SET3)
				return arabic_specs[i][IsLinkPrev(wPrevCode)];
		}
		return -1;
	}

	/*
	 * 前连接判�?? 返回�??: 0. 非前连接 1. 前连�??
	 */
	static int IsLinkPrev(int wCode) {
		if (wCode != 0) {
			int[] pwData = theSet1;
			long low, high, mid;
			low = 0;
			high = MAX_CNT_SET1 - 1;

			while (low <= high) {
				mid = (high + low) / 2;
				if (pwData[(int) mid] == wCode)
					return 1;
				else if (wCode > pwData[(int) mid])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}

		return 0;
	}

	/*
	 * 后连接判�?? 返回�??: 0. 非后连接 1. 后连�??
	 */
	static int IsLinkNext(int wCode) {
		if (wCode != 0) {
			int[] pwData = theSet2;
			long low, high, mid;
			low = 0;
			high = MAX_CNT_SET2 - 1;

			while (low <= high) {
				mid = (high + low) / 2;
				if (pwData[(int) mid] == wCode)
					return 1;
				else if (wCode > pwData[(int) mid])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		return 0;
	}

	// 主要针对Persian
	int ConvertRule3(int wPrevCode, int wCurCode, int wNextCode) {
		if (wCurCode >= 0x600 && wCurCode <= 0x6ff) {
			int i;
			int Persian_Alphabets[] = { 0x67e, 0x686, 0x698, 0x6a9, 0x6af,
					0x6cc };

			for (i = 0; i < PERSIAN_AlPHABET_CNT; i++)
				if (wCurCode == Persian_Alphabets[i])
					break;

			if (i < PERSIAN_AlPHABET_CNT) {
				int nPos = POS_ALONE;

				int bLinkPrev = IsLinkPrev(wPrevCode);
				int bLinkNext = IsLinkNext(wNextCode);

				boolean b = false;
				boolean c = false;
				if (bLinkNext == 1) {
					b = true;
				}
				if (bLinkPrev == 1) {
					c = true;
				}

				if (b && c)
					nPos = POS_MIDILE;
				else if (c)
					nPos = POS_LAST;
				else if (b)
					nPos = POS_FIRST;
				return Persian_AlphabetTab[i][nPos];
			}
		}

		return -1;
	}

	/*
	 * 判断该字串是否阿拉伯字符 返回�??: 0. 不包含阿拉伯字符. 1. 包含阿拉伯字�??.
	 */
	public int IsIncludeArbic(int wcs[]) {
		int sc[] = wcs;
		int i, len = sc.length;
		for (i = 0; i < len; i++) {
			if ((sc[i] >= 0x600 && sc[i] <= 0x6FF)
					|| (sc[i] >= 0x750 && sc[i] <= 0x77F)
					|| (sc[i] >= 0xFB50 && sc[i] <= 0xFDFF)
					|| (sc[i] >= 0xFE70 && sc[i] <= 0xFEFF))
				return 1;
		}
		return 0;
	}

}
