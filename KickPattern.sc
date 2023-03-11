
KickPattern {
	classvar patterns;

	*initClass {
		patterns = [
			((1 ! 7) ++ (0.5 ! 2)),
			((1 ! 6) ++ [0.75, 0.25, 0.5, 0.5]),
			((0.5 ! 14) ++ (0.25 ! 4)),
			[2.5, 1.5], // Drum & Bass
			[
				Pseq(1 ! 8, 1),
				Pseq(0.5 ! 16, 1),
				Pseq(0.25 ! 32, 1),
				Pseq(0.125 ! 64, 1),
				Pseq(((1 ! 7) ++ (0.5 ! 2)), inf)
			]
		];
	}

	random {
		^patterns[rrand(0,3)];
	}

	drumAndBass {
		^patterns[3];
	}

	get {
		|no|
		^patterns[no];
	}
}