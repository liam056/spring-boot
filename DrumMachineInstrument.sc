
DrumMachineInstrument {

	var tempoClock, instrument, rel, scale, volBus, synthGroup;
	var eventStreamPlayer;

	*new {
		|tempoClock, instrument, rel, scale, volBus, synthGroup|

		^super.newCopyArgs(tempoClock, instrument, rel, scale, volBus, synthGroup);
	}

	stopBeat {
		eventStreamPlayer.stop;
	}

	startBeat {
		|dur, instInput|

		var inst = instInput.collect({
			|i|

			if ( i ==1,
				{instrument;},
				{\rest;}
			)
		});

		var pattern = Pbind(
			\instrument, Pseq(inst, inf),
			\scale, scale,
			\degree, Pseq([0], inf),
			\octave, 3,
			\dur, Pseq(dur, inf),
			\amp, Pexprand( -3.dbamp, -1.dbamp, inf),
			\rel, rel,
			\mod, Pseq([4,2,4,2,4,4], inf),
			\volBus, volBus,
			\group, synthGroup
		);

		tempoClock.playNextBar({this.stopBeat; eventStreamPlayer = pattern.play(tempoClock, quant: 1)});
	}
}