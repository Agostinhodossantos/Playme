package app.play.me.utils

import app.play.me.model.Genre

class DataProvider {
    companion object {
         fun getGenreList(): List<Genre> {
            var list = mutableListOf<Genre>()
            list.add(Genre(1,  "Pop","#8d67ab", "https://t.scdn.co/images/0a74d96e091a495bb09c0d83210910c3" ))
            list.add(Genre(1,  "Dance/Electronic", "#dc148c", "https://i.scdn.co/image/ab67706f000000020377baccf69ede3cf1a26eff" ))
            list.add(Genre(1,  "Rock", "#e61e32", "https://i.scdn.co/image/ab67706f00000002fe6d8d1019d5b302213e3730"))
            list.add(Genre(1,  "Hip-Hop", "#ba5d07", "https://i.scdn.co/image/ab67706f000000029bb6af539d072de34548d15c"))
            list.add(Genre(1,  "Podcasts", "#27856a", "https://i.scdn.co/image/567158eb895ad26718a814345af0fc43ee785ec5"))
            list.add(Genre(1,  "New Releases", "#e8115b", "https://i.scdn.co/image/ab67706f000000027ea4d505212b9de1f72c5112"))
            list.add(Genre(1,  "Charts","#8d67ab", "https://charts-images.scdn.co/assets/locale_en/regional/weekly/region_global_default.jpg" ))
            list.add(Genre(1,  "Concerts","#1e3264" , "https://t.scdn.co/images/8cfa9cb1e43a404db76eed6ad594057c"))
            list.add(Genre(1,  "Made for you", "#1e3264", "https://t.scdn.co/images/ea364e99656e46a096ea1df50f581efe"))
            list.add(Genre(1,  "At Home", "#477d95", "https://i.scdn.co/image/ab67706f00000002d72ef75e14ca6f60ea2364c2"))
            list.add(Genre(1,  "Made for you", "#1e3264", "https://t.scdn.co/images/8cfa9cb1e43a404db76eed6ad594057c"))
            list.add(Genre(1,  "Afro", "#b49bc8", "https://t.scdn.co/images/b505b01bbe0e490cbe43b07f16212892.jpeg"))
            list.add(Genre(1,  "Only You", "#1e3264", "https://i.scdn.co/image/ab67706f0000000237df164786f688dd0ccd8744"))
            list.add(Genre(1,  "Mood", "#8d67ab", "https://i.scdn.co/image/ab67706f00000002aa93fe4e8c2d24fc62556cba"))
            list.add(Genre(1,  "R&B", "#dc148c", "https://i.scdn.co/image/ab67706f000000023c5a4aaf5df054a9beeb3d82"))
            list.add(Genre(1,  "Chill", "#477d95", "https://i.scdn.co/image/ab67706f000000025f7327d3fdc71af27917adba"))
            list.add(Genre(1,  "Indie", "#608108", "https://i.scdn.co/image/ab67706f0000000284a1ec26f589f0d569805a07"))
            list.add(Genre(1,  "EQUAL", "#148a08", "https://i.scdn.co/image/ab67706f000000026e1034ebd7b7c86546c6acca"))
            list.add(Genre(1,  "Soul", "#dc148c", "https://t.scdn.co/images/d0fb2ab104dc4846bdc56d72b0b0d785.jpeg"))
            list.add(Genre(1,  "Workout", "#148a08", "https://i.scdn.co/image/ab67706f000000029249b35f23fb596b6f006a15"))
            list.add(Genre(1,  "Gaming", "#e8115b", "https://i.scdn.co/image/ab67706f0000000221a2087747d946f16704b8af"))
            list.add(Genre(1,  "Alternative", "#f037a5", "https://t.scdn.co/images/ee9451b3ed474c82b1da8f9b5eafc88f.jpeg"))
            list.add(Genre(1,  "Kids & Family", "#8d67ab", "https://i.scdn.co/image/ab67706f00000002ec9d60059aa215a7ba364695"))
            list.add(Genre(1,  "Latin", "#9cf0e1", "https://t.scdn.co/images/26a60378-a374-4cd7-b894-28efa5e154cb.jpg"))
            list.add(Genre(1,  "Sleep", "#1e3264", "https://i.scdn.co/image/ab67706f00000002b70e0223f544b1faa2e95ed0"))
            list.add(Genre(1,  "Caribbean", "#0d73ec", "https://i.scdn.co/image/ab67706f00000002a76a2ccb454ff0e1720a51a5"))
            return list
        }

    }
}