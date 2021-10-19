package com.google.android.stardroid.space

import com.google.android.stardroid.ephemeris.Planet
import com.google.android.stardroid.math.Vector3
import java.util.*

/**
 * The Sun is special as it's at the center of the solar system.
 *
 * It's a sort of trivial sun-orbiting object.
 */
class Sun : SunOrbitingObject(Planet.Sun) {
    protected override fun getMyHeliocentricCoordinates(date: Date) =
        Vector3(0.0f, 0.0f, 0.0f)
}