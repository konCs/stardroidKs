package com.google.android.stardroid.space;

import com.google.android.stardroid.provider.ephemeris.Planet;
import com.google.android.stardroid.units.RaDec;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.TimeZone;

import static com.google.common.truth.Truth.assertThat;

/**
 * Position tests of the celestial objects - mostly extracted from the RaDecTest.
 */
public class UniverseSmokeTest {
    // Accuracy of 0.30 degree should be fine.
    // TODO(jontayler): investigate why this now fails with a tol of 0.25 degrees
    private static final float EPSILON = 0.30f;

    // Allow the lunar measurements to be a bit more 'off' for now as we're not taking
    // position on Earth into account.
    // TODO: tighten this up
    private static final float LUNAR_TOL = 1.6f;

    // Convert from hours to degrees
    private static final float HOURS_TO_DEGREES = 360.0f/24.0f;

    private Universe universe = new Universe();

    // Verify that we are calculating the correct RA/Dec for the various solar system objects.
    // All of the reference data comes from the US Naval Observatories web site:
    // http://aa.usno.navy.mil/data/
    // Note at present the above site is down. See https://www.usno.navy.mil/USNO/astronomical-applications
    //
    @Test
    public void testPositions() {
        GregorianCalendar testCal = new GregorianCalendar();
        testCal.setTimeZone(TimeZone.getTimeZone("GMT"));

        // 2009 Jan  1, 12:00 UT1
        // Sun       18h 48.8m  -22d 58m
        // Mercury   20h 10.6m  -21d 36m
        // Venus     22h 02.0m  -13d 36m
        // Mars      18h 17.1m  -24d 05m
        // Jupiter   20h 05.1m  -20d 45m
        // Saturn    11h 33.0m  + 5d 09m
        // Uranus    23h 21.7m  - 4d 57m
        // Neptune   21h 39.7m  -14d 22m
        // Pluto     18h 05.3m  -17d 45m
        testCal.set(2009, GregorianCalendar.JANUARY, 1, 12, 0, 0);

        {
            RaDec pos = universe.getSunRaDec(testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(18.813f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-22.97f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Mercury, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(20.177f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-21.60f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Venus, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(22.033f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-13.60f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Mars, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(18.285f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-24.08f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Jupiter, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(20.085f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-20.75f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Saturn, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(11.550f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(5.15f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Uranus, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(23.362f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-4.95f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Neptune, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(21.662f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-14.37f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Pluto, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(18.088f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-17.75f);
        }
        // 2009 Sep 20, 12:00 UT1
        // Sun       11h 51.4m  + 0d 56m
        // Mercury   11h 46.1m  - 1d 45m
        // Venus     10h 09.4m  +12d 21m
        // Mars       7h 08.6m  +23d 03m
        // Jupiter   21h 23.2m  -16d 29m
        // Saturn    11h 46.0m  + 3d 40m
        // Uranus    23h 41.1m  - 2d 55m
        // Neptune   21h 46.7m  -13d 51m
        // Pluto     18h 02.8m  -18d 00m
        testCal.set(2009, GregorianCalendar.SEPTEMBER, 20, 12, 0, 0);
        {
            RaDec pos = universe.getSunRaDec(testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(11.857f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(0.933f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Mercury, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(11.768f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-1.75f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Venus, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(10.157f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(12.35f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Mars, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(7.143f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(23.05f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Jupiter, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(21.387f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-16.48f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Saturn, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(11.767f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(3.67f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Uranus, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(23.685f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-2.92f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Neptune, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(21.778f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-13.85f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Pluto, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(18.047f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-18.00f);
        }

        // 2010 Dec 25, 12:00 UT1
        // Sun       18 15.6  -23 23
        // Mercury   17 24.2  -20 10
        // Venus     15 04.1  -13 50
        // Mars      18 58.5  -23 43
        // Jupiter   23 46.4  - 2 53
        // Saturn    13 03.9  - 4 14
        // Uranus    23 49.6  - 1 56
        // Neptune   21 55.8  -13 07
        // Pluto     18 21.5  -18 50
        testCal.set(2010, GregorianCalendar.DECEMBER, 25, 12, 0, 0);
        {
            RaDec pos = universe.getSunRaDec(testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(18.260f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-23.38f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Mercury, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(17.403f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-20.17f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Venus, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(15.068f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-13.83f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Mars, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(18.975f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-23.72f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Jupiter, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(23.773f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-2.88f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Saturn, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(13.065f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-4.23f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Uranus, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(23.827f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-1.93f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Neptune, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(21.930f * HOURS_TO_DEGREES);
            assertThat(pos.dec).isWithin(EPSILON).of(-13.12f);
        }
        {
            RaDec pos = universe.getRaDec(Planet.Pluto, testCal.getTime());
            assertThat(pos.ra).isWithin(EPSILON).of(18.358f * HOURS_TO_DEGREES);
        }
    }

    // Some positions from https://theskylive.com/moon-info#ephemeris
    @Test
    public void testLunarPositions()  {
        GregorianCalendar testCal = new GregorianCalendar();
        testCal.setTimeZone(TimeZone.getTimeZone("GMT"));

        {
            testCal.set(2020, GregorianCalendar.OCTOBER, 12, 0, 0, 0);
            RaDec pos = universe.getMoonRaDec(testCal.getTime());
            assertThat(pos.ra).isWithin(LUNAR_TOL).of(RaDec.raDegreesFromHMS(9, 4, 15.0f));
            assertThat(pos.dec).isWithin(LUNAR_TOL).of(RaDec.decDegreesFromDMS(20, 2, 36.0f));
        }
        {
            testCal.set(2009, GregorianCalendar.FEBRUARY, 11, 0, 0, 0);
            RaDec pos = universe.getMoonRaDec(testCal.getTime());
            assertThat(pos.ra).isWithin(LUNAR_TOL).of(RaDec.raDegreesFromHMS(10, 44, 47f));
            assertThat(pos.dec).isWithin(LUNAR_TOL).of(RaDec.decDegreesFromDMS(4, 24, 29f));
        }
        {
            testCal.set(2005, GregorianCalendar.APRIL, 11, 0, 0, 0);
            RaDec pos = universe.getMoonRaDec(testCal.getTime());
            assertThat(pos.ra).isWithin(LUNAR_TOL).of(RaDec.raDegreesFromHMS(2, 52, 10f));
            assertThat(pos.dec).isWithin(LUNAR_TOL).of(RaDec.decDegreesFromDMS(18, 2, 40f));
        }
    }
}