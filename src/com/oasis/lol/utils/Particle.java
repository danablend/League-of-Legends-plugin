package com.oasis.lol.utils;

import com.oasis.lol.Main;
import net.minecraft.server.v1_9_R1.EnumParticle;
import net.minecraft.server.v1_9_R1.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

/**
 * Created by Daniel on 28/07/2017 at 22:25.
 */

public enum Particle {

    CLOUD,
    COLOURED_DUST,
    CRIT,
    EXPLOSION,
    EXPLOSION_HUGE,
    EXPLOSION_LARGE,
    FIREWORKS_SPARK,
    FLAME,
    FLYING_GLYPH,
    FOOTSTEP,
    HAPPY_VILLAGER,
    HEART,
    INSTANT_SPELL,
    LARGE_SMOKE,
    LAVA_POP,
    LAVADRIP,
    MAGIC_CRIT,
    NOTE,
    PARTICLE_SMOKE,
    PORTAL,
    POTION_SWIRL,
    POTION_SWIRL_TRANSPARENT,
    SLIME,
    SMALL_SMOKE,
    SNOW_SHOVEL,
    SNOWBALL_BREAK,
    SPELL,
    SPLASH,
    TILE_BREAK,
    TILE_DUST,
    VILLAGER_THUNDERCLOUD,
    VOID_FOG,
    WATERDRIP,
    WITCH_MAGIC;

    /**
     * Plays an effect to all players within a default radius around a given location. The effect will use the provided material (and material data if required). The particle's position on the client will be the given location, adjusted on each axis by a normal distribution with mean 0 and standard deviation given in the offset parameters, each particle has independently calculated offsets. The effect will have the given speed and particle count if the effect is a particle. Some effect will create multiple particles.
     *
     * @param location - the Location around which players must be to see the effect
     * @param data - the data value of the block/item for the effect
     * @param offsetX - the amount to be randomly offset by in the X axis
     * @param offsetY - the amount to be randomly offset by in the Y axis
     * @param offsetZ - the amount to be randomly offset by in the Z axis
     * @param speed - the speed of the particles
     * @param particleCount - the number of particles
     * @param radius - the radius around the location
     */
    @SuppressWarnings("deprecation")
    public void spawnEffect(Location location, int data, float offsetX, float offsetY, float offsetZ, float speed, int particleCount, int radius) {
        Location loc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
        loc.getWorld().spigot().playEffect(loc, Effect.valueOf(this.toString()), Effect.valueOf(this.toString()).getId(), data, offsetX, offsetY, offsetZ, speed, particleCount, radius);
    }

    public static void createCircle(Location loc, float radius, Effect effect) {
        for (double a = 0; a < Math.PI * 2; a += Math.PI / 10) {
            double x = radius * Math.cos(a);
            double z = radius * Math.sin(a);
            Location circle = new Location(loc.getWorld(), (loc.getX() + x), loc.getY(), (loc.getZ() + z));
            loc.getWorld().spigot().playEffect(circle, effect, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 4, 15);
        }
    }

    public static void spawnHelix(final Location loc, final Vector offset, final EnumParticle particle) {
        loc.add(offset);
        new BukkitRunnable() {
            double s = 0.5; // meters per tick
            double t = -s;
            double r = 1;
            int limit = 20;
            Vector decreasePerTick = divideS(offset,limit / s);
            @Override
            public void run() {
                t = t + s;
                double x = r*Math.cos(t);
                double y = t;
                double z = r*Math.sin(t);
                loc.add(x, y, z);
                loc.subtract(decreasePerTick);
                PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
                        particle, //particleType
                        true, //true
                        (float)loc.getX(), //x position
                        (float)loc.getY(), //y position
                        (float)loc.getZ(), //z position
                        0,	// x offset
                        0,	// y offset
                        0, // z offset
                        0, // speed
                        1, // amount
                        null
                );

                if (t > limit) {
                    packet = new PacketPlayOutWorldParticles(
                            particle, //particleType
                            true, //true
                            (float)loc.getX(), //x position
                            (float)loc.getY(), //y position
                            (float)loc.getZ(), //z position
                            1,	// x offset
                            1,	// y offset
                            1, // z offset
                            1, // speed
                            1000, // amount
                            null
                    );
                    this.cancel();
                }
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (loc.distance(p.getLocation()) < 75) {
                        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
                    }
                }
                loc.subtract(x, y, z);
            }
        }.runTaskTimer(Main.getInstance(), 0, 1);
    }

    private static Vector divideS(Vector vector,double scaler) {
        Vector scalerVector = new Vector(scaler, scaler, scaler);
        return vector.divide(scalerVector);
    }

}
