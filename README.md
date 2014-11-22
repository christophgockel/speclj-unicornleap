# speclj-unicornleap

A speclj plugin to enable unicorns.

Requires [unicornleap](https://github.com/KevinLiddle/unicornleap)

## Installation

The project is available on [Clojars](https://clojars.org) (https://clojars.org/speclj-unicornleap) and therefore ready to be integrated as a dependency in Leiningen or Maven. How to do that specifically can be found on the [Clojars project site](https://clojars.org/speclj-unicornleap), for Leiningen the required entry for `:dependencies` is:

```
[speclj-unicornleap "0.1.0"]
```

If you're like me and want to avoid cluttering your `project.clj` files with a `:dev` dependency like that, Leiningen provides [default profiles](https://github.com/technomancy/leiningen/blob/master/doc/PROFILES.md#default-profiles)for that matter. So you can create a file under `~/.lein/profiles.clj` with content like:

```
{:user { :dependencies [[speclj-unicornleap "0.1.0"]]}}
```

This will download `speclj-unicornleap` on the next `lein` usage.


## Usage

I make use the autotest feature of speclj most of the time. To activate `speclj-unicornleap` with autotest run the following command:

```
lein spec -a -f unicornleap
```

This will give you the already known documentation based formatter with (!) unicorns.

If you run specs manually and want test progress output with unicorns you have to specify both formatters, like this:

```
lein spec -f p -f unicornleap`
```

Otherwise you would only see the unicorn (or troll).

### Why is that?

Since `speclj-unicornleap` is a formatter for `speclj`, the `-f unicornleap` commandline argument specifies `unicornleap` as the only formatter. To keep the default behaviour of speclj the argument `-f p` (for [p]rogress) is needed.

## Thanks
@8thLight for Waza Friday afternoons, @KevinLiddle for showing me [unicornleap](https://github.com/KevinLiddle/unicornleap).
