
DrumMachine {
	var kickPattern, tempoClock, synthGroup, scale, kickDrumMachineInstrument, snareDrumMachineInstrument, hatDrumMachineInstrument;

	*new {
		|tempoClock, synthGroup, scale, kickSynth, kickVolBus, snareSynth, snareVolBus, hatSynth, hatVolBus|
		^super.newCopyArgs(
			KickPattern.new,
			tempoClock,
			synthGroup,
			scale,
			DrumMachineInstrument(tempoClock, kickSynth, 1, scale, kickVolBus, synthGroup),
			DrumMachineInstrument(tempoClock, snareSynth, 1, scale, snareVolBus, synthGroup),
			DrumMachineInstrument(tempoClock, hatSynth, 1, scale, hatVolBus, synthGroup),
		);
	}

	randomKicks {
		kickDrumMachineInstrument.startBeat(kickPattern.random, [1]);
	}

	drumAndBass {
		kickDrumMachineInstrument.startBeat(kickPattern.get(3), [1]);
		snareDrumMachineInstrument.startBeat([1], [0, 1]);
		hatDrumMachineInstrument.startBeat([0.5], [1]);
	}

	hardcore {
		|kickNum|

		kickDrumMachineInstrument.startBeat(kickPattern.get(kickNum), [1]);
		snareDrumMachineInstrument.startBeat([1], [0, 1]);
		hatDrumMachineInstrument.startBeat([0.5], [1]);
	}

	kickPattern {
		|patternArray, instrumentArray|

		kickDrumMachineInstrument.startBeat(patternArray, instrumentArray);
	}

	snarePattern {
		|patternArray, instrumentArray|

		snareDrumMachineInstrument.startBeat(patternArray, instrumentArray);
	}

	hatPattern {
		|patternArray, instrumentArray|

		hatDrumMachineInstrument.startBeat(patternArray, instrumentArray);
	}

	stopKick {
		kickDrumMachineInstrument.stopBeat;
	}

	stopSnare {
		kickDrumMachineInstrument.stopBeat;
	}

	stopHat {
		kickDrumMachineInstrument.stopBeat;
	}

	stopAll {
		this.stopKick;
		this.stopSnare;
		this.stopHat;
	}
}